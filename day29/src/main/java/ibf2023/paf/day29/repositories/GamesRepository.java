package ibf2023.paf.day29.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class GamesRepository {

   @Autowired
   private MongoTemplate template;

   public List<Document> findGameByName(String name) {

      // { 
      //    $match: { 
      //       name: { $regex: "ticket", $options: "i" }
      //    } 
      // }
      MatchOperation matchName = Aggregation.match(
         Criteria.where("name").regex(name, "i")
      );

      // {
      //    $sort: { ranking: -1 }
      // ,
      SortOperation sortGamesByRanking = Aggregation.sort(
         Sort.by(Sort.Direction.DESC, "ranking")
      );

      // {
      //    $project: { _id: "$gid", name: 1, year: 1, ranking: 1, users_rated: 1, url: 1, image: 1 }
      // },
      ProjectionOperation selectFields = Aggregation.project(
               "name", "year", "ranking", "users_rated", "url", "image")
            .and("gid").as("_id");

      // {
      //    $lookup: {
      //       from: "comments",
      //       foreignField: "gid",
      //       localField: "_id",
      //       pipeline: [
      //          { $sort: { rating: -1 } },
      //          { $limit: 5 }
      //       ],
      //       as: "reviews"
      //    }
      // }
      LookupOperation findCommentsByGameId = Aggregation.lookup()
         .from("comments")
         .localField("_id")
         .foreignField("gid")
         .pipeline(
            Aggregation.sort(Sort.by(Sort.Direction.DESC, "rating")),
            Aggregation.limit(5)
         ).as("comments");

      Aggregation pipeline = Aggregation.newAggregation(
         matchName, sortGamesByRanking, selectFields, findCommentsByGameId
      );

      return template.aggregate(pipeline, "games", Document.class).getMappedResults();
   }
   
}

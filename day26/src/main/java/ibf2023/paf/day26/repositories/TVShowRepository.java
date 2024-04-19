package ibf2023.paf.day26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import ibf2023.paf.day26.Constants;

@Repository
public class TVShowRepository {

   @Autowired
   private MongoTemplate template;

   /*
    * db.tvshows.find({
      name: { $regex: 'name', $options: 'i' },
      genres: { $all: [ 'Drama', 'Thriller' ] }
    })
    .projection({ name: 1, genres: 1 })
    .sort({ name: -1 })
    .limit(5)
    */
   public List<Document> findShowsByName(String name) {
      // Create the filter
      Criteria criteria = Criteria
            .where(Constants.F_NAME).regex(name, "i")
            .and(Constants.F_GENRES).all("Drama", "Thriller");

      // Create the query with the filter
      Query query = Query.query(criteria)
         .with(Sort.by(Direction.DESC, Constants.F_NAME))
         .limit(5);
      query.fields().include(Constants.F_NAME, Constants.F_GENRES);

      return template.find(query, Document.class, Constants.C_TVSHOWS);
   }

   /*
    * db.tvshows.find({ 
         language: { $regex: 'language', $options: 'i' } 
      }).count()
    */
    public long countShowsByLanguage(String lang) {
      Criteria criteria = Criteria
            .where(Constants.F_LANGUAGE).regex(lang, "i");

      Query query = Query.query(criteria);

      return template.count(query, Constants.C_TVSHOWS);
    }

    /*
     * db.tvshows.distinct("type", { "ratings.average": { $gte: 7 } }) 
     */
    public List<String> getTypesByRating(float rating) {
      Criteria criteria = Criteria
            .where(Constants.F_AVERGE_RATING).gte(rating);

      Query query = Query.query(criteria);

      return template.findDistinct(query, Constants.F_TYPE, Constants.C_TVSHOWS, String.class);
    }
}

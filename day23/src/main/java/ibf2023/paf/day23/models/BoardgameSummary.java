package ibf2023.paf.day23.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public record BoardgameSummary(String name, int reviewCount, float averageRating) {

   public static BoardgameSummary toBoardgameSummary(SqlRowSet rs) {
      String name = rs.getString("name");
      int commentsCount = rs.getInt("comments_count");
      float averageRating = rs.getFloat("avg_rating");
      return new BoardgameSummary(name, commentsCount, averageRating);
   }
}

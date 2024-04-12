package ibf2023.paf.day23.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2023.paf.day23.models.BoardgameSummary;

@Repository
public class BoardgameRepository {

  @Autowired
  private JdbcTemplate template;

  public List<BoardgameSummary> getBoardgameStatistics(String name) {

    List<BoardgameSummary> results = new LinkedList<>();

    SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_GAME_STATISTICS, name);
    while (rs.next())
      results.add(BoardgameSummary.toBoardgameSummary(rs));

    return results;
  }
}

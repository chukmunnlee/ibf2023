package ibf2023.paf.day23.repositories;

public class Queries {
   public static final String SQL_SELECT_GAME_STATISTICS = """
        select g.gid, g.name, count(c.c_id) as comments_count, avg(c.rating) as avg_rating 
	        from game as g 
           join comment as c 
           on g.gid = c.gid 
           where g.name like ?
           group by g.gid
           order by avg_rating desc; 
         """;
}
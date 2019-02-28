import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class Dao {
	
		private Connection connection = null;
		private String connectionstring = "jdbc:sqlite:sample.db";

		public Dao() {
			
	        try
	        {
	          // create a database connection
	          connection = DriverManager.getConnection(connectionstring);
	          Statement statement = connection.createStatement();
	          statement.setQueryTimeout(30); // set timeout to 30 sec.
	          statement.executeUpdate("create table if not exists ToDo  (id integer primary key autoincrement NOT NULL, description string, completed integer )");
	        
	        }
	        catch(SQLException e)
	        {
	          // if the error message is "out of memory",
	          // it probably means no database file is found
	          System.err.println(e.getMessage());
	        }
	        finally
	        {
	          try
	          {
	            if(connection != null)
	              connection.close();
	          }
	          catch(SQLException e)
	          {
	            // connection close failed.
	            System.err.println(e.getMessage());
	          }
	        }
		}
		
		private Connection connect() {
	      
	       
	        try {
	        	connection = DriverManager.getConnection(connectionstring);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return connection;
	    }

		public void add(String description) {
			String sql = "INSERT INTO ToDo (description,completed ) VALUES(?,?)";
			
			 try (Connection conn = this.connect();
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setString(1, description);
		            pstmt.setInt(2, 0);
		            pstmt.executeUpdate();
		        } 
			 catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		      
		        finally
		        {
		          try
		          {
		            if(connection != null)
		              connection.close();
		          }
		          catch(SQLException e)
		          {
		            // connection close failed.
		            System.err.println(e.getMessage());
		          }
		        }
			
		}
		
		
		public List<ToDo> getToDoEntries(String status) {

			// check to find list of active entries in current database
			List<ToDo> toDoEntries = new ArrayList<ToDo>();		
			String sql = "select * from ToDo";
			 
			 try (Connection conn = this.connect();
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
		          ResultSet rs = pstmt.executeQuery();      
		          if(rs!=null)
		          {
		        	  while (rs.next()) 
		        	  {
		        		  String desc=rs.getString("description");
		        		  int id=rs.getInt("id");
		        		 boolean completedflag=(rs.getInt("completed")==1?true:false);
		        		  ToDo todoobject= new ToDo(id, desc,completedflag);
		        		 if(status.equals("done") && todoobject.getCompletedFlag()==true)  
		        			 toDoEntries.add(todoobject);  
		        		 else if(status.equals("pending") && !todoobject.getCompletedFlag()==true)  
		        			 toDoEntries.add(todoobject); 
		        		 else if (status.equals("all"))
		        			 toDoEntries.add(todoobject); 
		        			 
		        		  
		        	  }
		          }
		        }
		        catch(SQLException e)
		        {
		          // if the error message is "out of memory",
		          // it probably means no database file is found
		          System.err.println(e.getMessage());
		        }
		        finally
		        {
		          try
		          {
		            if(connection != null)
		              connection.close();
		          }
		          catch(SQLException e)
		          {
		            // connection close failed.
		            System.err.println(e.getMessage());
		          }
		        }
	       return toDoEntries;
			
		}

	

		public int delete(int id) {
			String sql = "Delete from ToDo where id=?";
			
			 try (Connection conn = this.connect();
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setInt(1, id);
		            return pstmt.executeUpdate();
			 }

			
	        catch(SQLException e)
	        {
	          // if the error message is "out of memory",
	          // it probably means no database file is found
	          System.err.println(e.getMessage());
	        }
	        finally
	        {
	          try
	          {
	            if(connection != null)
	              connection.close();
	          }
	          catch(SQLException e)
	          {
	            // connection close failed.
	            System.err.println(e.getMessage());
	          }
	        }
			return 0;

		}

		public int update(int id) {			
			
			String sql = "Update ToDo set completed=1 where id=?";
			
			 try (Connection conn = this.connect();
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setInt(1, id);
		           return pstmt.executeUpdate();
			 }
	        catch(SQLException e)
	        {
	          // if the error message is "out of memory",
	          // it probably means no database file is found
	          System.err.println(e.getMessage());
	        }
	        finally
	        {
	          try
	          {
	            if(connection != null)
	              connection.close();
	          }
	          catch(SQLException e)
	          {
	            // connection close failed.
	            System.err.println(e.getMessage());
	          }
	        }
			return 0;
		}
	
}

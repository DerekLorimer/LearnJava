import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.mockito.Matchers;

public class MockResultSet {
 
  private final Map<String, Integer> columnIndices;
  private final Object[][] data;
  private int rowIndex;
 
  private MockResultSet(final String[] columnNames,
                        final Object[][] data) {
    // create a map of column name to column index
    this.columnIndices = IntStream.range(0, columnNames.length)
        .boxed()
        .collect(Collectors.toMap(
            k -> columnNames[k],
            Function.identity(),
            (a, b) ->
              { throw new RuntimeException("Duplicate column " + a); },
            LinkedHashMap::new
            ));
    this.data = data;
    this.rowIndex = -1;
  }
 
  private ResultSet buildMock() throws SQLException {
    ResultSet rs = mock(ResultSet.class);
 
    // mock rs.next()
    doAnswer(invocation -> {
      rowIndex++;
      return rowIndex < data.length;
    }).when(rs).next();
 
    // mock rs.getString(columnName)
    doAnswer(invocation -> {
      String columnName = invocation.getArgument(0, String.class);
      Integer columnIndex = columnIndices.get(columnName);
      return (String) data[rowIndex][columnIndex];
    }).when(rs).getString(Matchers.anyString());
    
    doAnswer(invocation -> {
        String columnName = invocation.getArgument(0, String.class);
        Integer columnIndex = columnIndices.get(columnName);
        return (Integer) data[rowIndex][columnIndex];
      }).when(rs).getInt(Matchers.anyString());
   
 
    // mock rs.getObject(columnIndex)
    doAnswer(invocation -> {
      Integer index = invocation.getArgument(0, Integer.class);
      return data[rowIndex][index - 1];
    }).when(rs).getObject(Matchers.anyInt());
 
    ResultSetMetaData rsmd = mock(ResultSetMetaData.class);
 
    // mock rsmd.getColumnCount()
    doReturn(columnIndices.size()).when(rsmd).getColumnCount();
 
    // mock rs.getMetaData()
    doReturn(rsmd).when(rs).getMetaData();
 
    return rs;
  }
 
  /**
   * Creates the mock ResultSet.
   *
   * @param columnNames the names of the columns
   * @param data
   * @return a mocked ResultSet
   * @throws SQLException
   */
  public static ResultSet create(
                         final String[] columnNames,
                         final Object[][] data)
                         throws SQLException {
    return new MockResultSet(columnNames, data).buildMock();
  }
}

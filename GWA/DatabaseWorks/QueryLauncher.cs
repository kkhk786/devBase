using MySql.Data.MySqlClient;
using System;
using System.Data;

namespace GWA.DatabaseWorks
{
    public class QueryLauncher
    {
        public DataTable LaunchSelectQuery(string strQuery, string strConnection)
        {
            DataTable dt = new DataTable();
            MySqlConnection conn = new MySqlConnection(strConnection);
            try
            {
                conn.Open();

                MySqlCommand cmd = new MySqlCommand(strQuery, conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                dt.Load(reader);
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
                System.Diagnostics.Debug.WriteLine(e.StackTrace);
            }
            finally
            {
                conn.Close();
            }
            return dt;
        }

        public bool LaunchNonQuery(string strQuery, string strConnection)
        {
            MySqlConnection conn = new MySqlConnection(strConnection);
            try
            {
                conn.Open();

                MySqlCommand cmd = new MySqlCommand(strQuery, conn);
                cmd.ExecuteNonQuery();
                return true;
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
                System.Diagnostics.Debug.WriteLine(e.StackTrace);
                return false;
            }
            finally
            {
                conn.Close();
            }
        }

        public int GetSingleIntegerFromDB(string strQuery, string strConnection)
        {
            int intResult = 0;
            DataTable dataTable = new DataTable();
            dataTable = LaunchSelectQuery(strQuery, strConnection);
            intResult = Int32.Parse(dataTable.Rows[0][0].ToString());

            return intResult;
        }
    }
}
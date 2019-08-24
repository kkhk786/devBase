using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GWA.DatabaseWorks.QueryWriter
{
    public class QW01_SignIn
    {
        /// <summary>
        /// アカウント名、パスワードでユーザをチェック
        /// </summary>
        /// <param name="strAccountName"></param>
        /// <param name="strPassword"></param>
        /// <returns></returns>
        public string DoesAccountInfoExist(string strAccountName, string strPassword)
        {
            string strQuery = "";

            strQuery += "SELECT";
            strQuery += "  COUNT(*) ";
            strQuery += "FROM";
            strQuery += "  tbl01_accountinfo ";
            strQuery += "WHERE";
            strQuery += "  AccountName = '" + strAccountName + "'";
            strQuery += "  AND Password = '" + strPassword + "'";
            strQuery += "ORDER BY";
            strQuery += "  AccountName";

            return strQuery;
        }

        public string GetAccountInfo(string strAccountName)
        {
            string strQuery = "";

            strQuery += "SELECT";
            strQuery += "  * ";
            strQuery += "FROM";
            strQuery += "  tbl01_accountinfo ";
            strQuery += "WHERE";
            strQuery += "  AccountName = '" + strAccountName + "';";

            return strQuery;
        }
    }
}
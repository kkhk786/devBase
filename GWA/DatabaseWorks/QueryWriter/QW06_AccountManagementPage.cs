using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace GWA.DatabaseWorks.QueryWriter
{
    public class QW06_AccountManagementPage
    {
        public string GetAllAccounts()
        {
            string strQuery = "";

            strQuery += "SELECT";
            strQuery += "  * ";
            strQuery += "FROM";
            strQuery += "  tbl01_accountinfo;";

            return strQuery;
        }

        public string DeleteByAccountName(string strParam01_AccountName)
        {
            string strQuery = "";
            strQuery += "DELETE ";
            strQuery += "FROM";
            strQuery += "  tbl01_accountinfo ";
            strQuery += "WHERE";
            strQuery += "  `AccountName` = '" + strParam01_AccountName + "'";
            return strQuery;
        }

        public string UpdateByAccountName(
            string strParam01_AccountName,
            string strParam02_AccountType,
            string strParam03_FirstName,
            string strParam04_LastName,
            string strParam05_Email,
            string strParam06_HomeAddress,
            string strParam07_WorkPlace
            )
        {
            /* データ編集ターゲット
             * AccountType
             * FirstName
             * LastName
             * Email
             * HomeAddress
             * WorkPlace
             */

            string strQuery = "";

            strQuery += "UPDATE tbl01_accountinfo ";
            strQuery += "SET";
            strQuery += "  `AccountType` = '" + strParam02_AccountType + "'";
            strQuery += "  , `FirstName` = '" + strParam03_FirstName + "'";
            strQuery += "  , `LastName` = '" + strParam04_LastName + "'";
            strQuery += "  , `Email` = '" + strParam05_Email + "'";
            strQuery += "  , `HomeAddress` = '" + strParam06_HomeAddress + "'";
            strQuery += "  , `Workplace` = '" + strParam07_WorkPlace + "'";
            strQuery += "  , `UpdatedDateTime` = CURRENT_TIMESTAMP ";
            strQuery += "WHERE";
            strQuery += "  `AccountName` = '" + strParam01_AccountName + "'";

            return strQuery;
        }

        public string InsertNewAccount(
            string strParam01_AccountName,
            string strParam02_Password,
            string strParam03_Firstname,
            string strParam04_Lastname,
            string strParam05_EmailAddress
            )
        {
            string strQuery = string.Empty;

            strQuery += "INSERT ";
            strQuery += "INTO test.tbl01_accountinfo( ";
            strQuery += "  `AccountName`";
            strQuery += "  , `AccountType`";
            strQuery += "  , `Password`";
            if(strParam03_Firstname != string.Empty)
            {
                strQuery += "  , `FirstName`";
            }
            if(strParam04_Lastname != string.Empty)
            {
                strQuery += "  , `LastName`";
            }
            if(strParam05_EmailAddress != string.Empty)
            {
                strQuery += "  , `Email`";
            }
            
            strQuery += "  , `RegisteredDateTime`";
            strQuery += ") ";
            strQuery += "VALUES ( ";
            strQuery += "  '" + strParam01_AccountName + "'";
            strQuery += "  , 'Guest'";
            strQuery += "  , '" + strParam02_Password + "'";
            if(strParam03_Firstname != string.Empty)
            {
                strQuery += "  , '" + strParam03_Firstname + "'";
            }
            
            if (strParam04_Lastname != string.Empty)
            {
                strQuery += "  , '" + strParam04_Lastname + "'";
            }
                
            if (strParam05_EmailAddress != string.Empty)
            {
                strQuery += "  , '" + strParam05_EmailAddress + "'";
            }
            strQuery += "  , CURRENT_TIMESTAMP";
            strQuery += ")";

            return strQuery;
        }
    }


}
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using GWA.DatabaseWorks;
using GWA.DatabaseWorks.QueryWriter;

namespace GWA.PageWorks
{
    public partial class P01_Main : System.Web.UI.Page
    {
        public string strConnection = "";

        protected void Page_Load(object sender, EventArgs e)
        {
            this.strConnection = ConfigurationManager.AppSettings["ConnectionString_testDB"].ToString();
            lblLoginFailedMessage.Visible = false;
        }

        /// <summary>
        /// サインイン（ログイン）ボタン押下時の動作
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void btnSignIn_Click(object sender, EventArgs e)
        {
            string strAccountName = tbAccountName.Text;
            string strPassword = tbPassword.Text;
            bool boolIsAccountOK = CheckAccountInfo(strAccountName, strPassword);
            DataTable dtAccountInfo = new DataTable();

            if (boolIsAccountOK == true)
            {
                lblLoginFailedMessage.Visible = false;
                GetAccountInfoAsSessionData(strAccountName);
                Session["SignedAccount"] = strAccountName;
                dtAccountInfo = (DataTable)Session["ssDtAccountInfo"];
                if (0 < dtAccountInfo.Rows.Count)
                {
                    if (dtAccountInfo.Rows[0]["AccountType"].ToString() == "Administrator")
                    {
                        // アカウント名、パスワードがOKで、アカウントタイプが「管理者」の場合
                        Response.Redirect(@"\PageWorks\P04_AdminPage.aspx");
                    }
                    else
                    {
                        // アカウント名、パスワードがOKで、アカウントタイプが「管理者」以外の場合
                        Response.Redirect(@"\PageWorks\P05_MainPage.aspx");
                    }
                }
            }
            else
            {
                lblLoginFailedMessage.Visible = true;
                lblLoginFailedMessage.ForeColor = System.Drawing.Color.Red;
                lblLoginFailedMessage.Font.Bold = true;
            }
        }

        private bool CheckAccountInfo(string strAccountName, string strPassword)
        {
            QW01_SignIn queryWriter = new QW01_SignIn();
            QueryLauncher queryLauncher = new QueryLauncher();

            bool boolResult = false;
            int intAccountCount = 0;

            string strQuery = queryWriter.DoesAccountInfoExist(strAccountName, strPassword);
            intAccountCount = queryLauncher.GetSingleIntegerFromDB(strQuery, strConnection);

            if (0 < intAccountCount)
            {
                boolResult = true;

            }
            else
            {
                boolResult = false;
            }

            return boolResult;
        }

        private void GetAccountInfoAsSessionData(string strAccountName)
        {
            QW01_SignIn qw01 = new QW01_SignIn();
            QueryLauncher ql = new QueryLauncher();
            DataTable dtAccountInfo = new DataTable();

            string strQuery = qw01.GetAccountInfo(strAccountName);
            dtAccountInfo = ql.LaunchSelectQuery(strQuery, strConnection);

            Session["ssDtAccountInfo"] = dtAccountInfo;
        }
    }
}
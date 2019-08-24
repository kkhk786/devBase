using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace GWA
{
    public partial class Default : System.Web.UI.Page
    {
        public static string connString = System.Configuration.ConfigurationManager.AppSettings["ConnectionString_testDB"].ToString();

        protected void Page_Load(object sender, EventArgs e)
        {
            // セッションチェックを実施
            bool boolSessionCheck = IsSessionStillAlive();
            // セッションが生きていない場合、もしくはログインしたことがない場合
            if(boolSessionCheck == false)
            {
                Response.Redirect(@"PageWorks\P01_SignIn.aspx");
            } else
            {
                Response.Redirect(@"PageWorks\P04_AdminPage.aspx");
            }

        }

        private bool IsSessionStillAlive()
        {
            bool boolResult = false;
            if((DataTable)Session["ssDtAccountInfo"] != null)
            {
                boolResult = true;
            }
            return boolResult;
        }
    }
}
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using GWA.DatabaseWorks.QueryWriter;

namespace GWA.PageWorks
{
    public partial class P04_MainPage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            QW04_MainPage qw04 = new QW04_MainPage();
            string strAccountName = Session["SignedAccount"].ToString();
            lblAccountName.Text = strAccountName;
            DataTable dtAccountInfo = new DataTable();
            string strGetAccountInfo = qw04.GetAccountInfoByAccountName(strAccountName);
        }
    }
}
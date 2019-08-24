using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace GWA.PageWorks
{
    public partial class P04_AdminPage : System.Web.UI.Page
    {
        public DataTable dtAccountInfo = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            this.dtAccountInfo = (DataTable)Session["ssDtAccountInfo"];
        }

        protected void btnAccountManagement_Click(object sender, EventArgs e)
        {
            Response.Redirect(@"\PageWorks\P06_AccountManagementPage.aspx");
        }
    }
}
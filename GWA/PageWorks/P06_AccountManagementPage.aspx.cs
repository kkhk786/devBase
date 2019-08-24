#region Using directives
using System;
using GWA.DatabaseWorks;
using GWA.DatabaseWorks.QueryWriter;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.Data;
#endregion Using directives

namespace GWA.PageWorks
{
    public partial class P06_AccountManagementPage : System.Web.UI.Page
    {
        string strConnection = ConfigurationManager.AppSettings["ConnectionString_testDB"].ToString();

        /// <summary>
        /// ページロード時
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void Page_Load(object sender, EventArgs e)
        {
            InitializeDataSource();

            gvAllAccountInfo.AllowPaging = true;
            gvAllAccountInfo.PageSize = 10;

            gvAllAccountInfo.AllowSorting = true;
            ViewState["SortExpression"] = "RegisteredDateTime DESC";

            BindGridView();
        }

        /// <summary>
        /// データをイニシャライズ
        /// </summary>
        private void InitializeDataSource()
        {
            QW06_AccountManagementPage queryWriter = new QW06_AccountManagementPage();
            QueryLauncher queryLauncher = new QueryLauncher();
            DataTable dtAccountInfo = queryLauncher.LaunchSelectQuery(queryWriter.GetAllAccounts(), strConnection);

            ViewState["dtAccountInfo"] = dtAccountInfo;
        }

        /// <summary>
        /// グリッドビューをバインド
        /// </summary>
        private void BindGridView()
        {
            if (ViewState["dtAccountInfo"] != null)
            {
                // ビューステートからデータテーブルを取得
                DataTable dtAccountInfo = (DataTable)ViewState["dtAccountInfo"];

                // データテーブルをデータビューに変換する
                DataView dvAccountInfo = new DataView(dtAccountInfo);

                // ソートカラム、ソート順版をを追加
                dvAccountInfo.Sort = ViewState["SortExpression"].ToString();

                // グリッドビューコントロールをバインド
                gvAllAccountInfo.DataSource = dvAccountInfo;
                gvAllAccountInfo.DataBind();
            }
        }

        protected void gvAllAccountInfo_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            // 現在のGridViewRowがデータ行であるかを確かめる
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                // データコントロール（普通）、データコントロール（代替）の行である場合
                if (e.Row.RowState == DataControlRowState.Normal || e.Row.RowState == DataControlRowState.Alternate)
                {
                    // 削除押下時、クライアント側の許可を許可を得るようにメッセージ表示
                    ((LinkButton)e.Row.Cells[1].Controls[0]).Attributes["onclick"] = "if(!confirm('削除を実施しますか？')) return false;";
                }
            }
        }

        // グリッドビューのページングイベント
        protected void gvAllAccountInfo_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvAllAccountInfo.PageIndex = e.NewPageIndex;

            BindGridView();
        }

        protected void gvAllAccountInfo_RowEditing(object sender, GridViewEditEventArgs e)
        {
            gvAllAccountInfo.EditIndex = e.NewEditIndex;

            BindGridView();
        }

        protected void gvAllAccountInfo_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            gvAllAccountInfo.EditIndex = -1;

            BindGridView();
        }

        protected void gvAllAccountInfo_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            if (ViewState["dtAccountInfo"] != null)
            {
                QW06_AccountManagementPage queryWriter = new QW06_AccountManagementPage();
                QueryLauncher queryLauncher = new QueryLauncher();

                DataTable dtAccountInfo = (DataTable)ViewState["dtAccountInfo"];

                string strAccountType = "";
                string strFirstName = "";
                string strLastName = "";
                string strEmail = "";
                string strHomeAddress = "";
                string strWorkPlace = "";

                string strAccountName = gvAllAccountInfo.Rows[e.RowIndex].Cells[2].Text;
                string str3 = gvAllAccountInfo.Rows[e.RowIndex].Cells[3].Text;
                string str4 = gvAllAccountInfo.Rows[e.RowIndex].Cells[4].Text;
                string str5 = gvAllAccountInfo.Rows[e.RowIndex].Cells[5].Text;
                string str6 = gvAllAccountInfo.Rows[e.RowIndex].Cells[6].Text;
                string str7 = gvAllAccountInfo.Rows[e.RowIndex].Cells[7].Text;

                GridViewRow gvr = gvAllAccountInfo.Rows[e.RowIndex];
                System.Diagnostics.Debug.WriteLine("e.RowIndex : " + e.RowIndex);

                //strAccountType = ((TextBox)gvAllAccountInfo.Rows[e.RowIndex].FindControl("tbAccountType")).Text;
                TextBox tbNewAccountType = (TextBox)gvr.FindControl("tbAccountType");
                strAccountType = tbNewAccountType.Text;
                strFirstName = ((TextBox)gvAllAccountInfo.Rows[e.RowIndex].FindControl("tbFirstName")).Text;
                strLastName = ((TextBox)gvAllAccountInfo.Rows[e.RowIndex].FindControl("tbLastName")).Text;
                strEmail = ((TextBox)gvAllAccountInfo.Rows[e.RowIndex].FindControl("tbEmail")).Text;
                strHomeAddress = ((TextBox)gvAllAccountInfo.Rows[e.RowIndex].FindControl("tbHomeAddress")).Text;
                strWorkPlace = ((TextBox)gvAllAccountInfo.Rows[e.RowIndex].FindControl("tbWorkPlace")).Text;

                //// Simple Test
                //System.Diagnostics.Debug.WriteLine("_/_/_/_/_/_/_/_/_/_/_/_/_/_/");
                //System.Diagnostics.Debug.WriteLine(((TextBox)gvAllAccountInfo.Rows[e.RowIndex].FindControl("tbFirstName")).Text);

                //System.Diagnostics.Debug.WriteLine(gvAllAccountInfo.Rows[e.RowIndex].Cells[1].Text);
                //System.Diagnostics.Debug.WriteLine(gvAllAccountInfo.Rows[e.RowIndex].Cells[2].Text);
                //System.Diagnostics.Debug.WriteLine(gvAllAccountInfo.Rows[e.RowIndex].Cells[3].Text);
                //System.Diagnostics.Debug.WriteLine(gvAllAccountInfo.Rows[e.RowIndex].Cells[4].Text);
                //System.Diagnostics.Debug.WriteLine("_/_/_/_/_/_/_/_/_/_/_/_/_/_/");

                System.Diagnostics.Debug.WriteLine("====================================");
                //System.Diagnostics.Debug.WriteLine("strAccountName : " + strAccountName);
                System.Diagnostics.Debug.WriteLine("strAccountType : " + strAccountType);
                //System.Diagnostics.Debug.WriteLine("strFirstName : " + strFirstName);
                //System.Diagnostics.Debug.WriteLine("strLastName : " + strLastName);
                //System.Diagnostics.Debug.WriteLine("strEmail : " + strEmail);
                //System.Diagnostics.Debug.WriteLine("strHomeAddress : " + strHomeAddress);
                //System.Diagnostics.Debug.WriteLine("strWorkPlace : " + strWorkPlace);
                System.Diagnostics.Debug.WriteLine("====================================");
                //string strQuery_UpdateAccount = queryWriter.UpdateByAccountName(strAccountName, strAccountType, strFirstName, strLastName, strEmail, strHomeAddress, strWorkPlace);
                //queryLauncher.LaunchNonQuery(strQuery_UpdateAccount, strConnection);

                gvAllAccountInfo.EditIndex = -1;

                ReInitializeAndBindGridView();
            }
        }

        protected void gvAllAccountInfo_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            QW06_AccountManagementPage queryWriter = new QW06_AccountManagementPage();
            QueryLauncher queryLauncher = new QueryLauncher();

            DataTable dtAccountInfo = (DataTable)ViewState["dtAccountInfo"];
            string strAccountName = gvAllAccountInfo.Rows[e.RowIndex].Cells[2].Text;

            string strQuery_DeleteAccountByAccountName = queryWriter.DeleteByAccountName(strAccountName);
            queryLauncher.LaunchNonQuery(strQuery_DeleteAccountByAccountName, strConnection);

            ReInitializeAndBindGridView();

        }

        protected void gvAllAccountInfo_Sorting(object sender, GridViewSortEventArgs e)
        {

        }

        protected void btnToAdminPage_Click(object sender, EventArgs e)
        {
            Response.Redirect(@"\PageWorks\P04_AdminPage.aspx");
        }

        protected void lbtnSubmit_Click(object sender, EventArgs e)
        {

        }

        protected void lbtnCancel_Click(object sender, EventArgs e)
        {

        }

        private void ReInitializeAndBindGridView()
        {
            InitializeDataSource();
            BindGridView();
        }

        protected void btnConfirmNewAccount_Click(object sender, EventArgs e)
        {
            QW06_AccountManagementPage queryWriter = new QW06_AccountManagementPage();
            QueryLauncher queryLauncher = new QueryLauncher();

            string strNewAccount_AccountName = tbNewAccount_AccountName.Text;
            string strNewAccount_Password = tbNewAccount_Password.Text;
            string strNewAccount_FirstName = tbNewAccount_FirstName.Text;
            string strNewAccount_LastName = tbNewAccount_LastName.Text;
            string strNewAccount_EmailAddress = tbNewAccount_EmailAddress.Text;

            string strQueryAddNewAccount = queryWriter.InsertNewAccount(strNewAccount_AccountName, strNewAccount_Password, strNewAccount_FirstName, strNewAccount_LastName, strNewAccount_EmailAddress);
            bool launch = queryLauncher.LaunchNonQuery(strQueryAddNewAccount, strConnection);
        }
    }
}
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="P04_AdminPage.aspx.cs" Inherits="GWA.PageWorks.P04_AdminPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            管理者ページ
        </div>
        <div>
            <asp:Button runat="server" ID="btnAccountManagement" Text="ユーザ管理" OnClick="btnAccountManagement_Click" />
        </div>
    </form>
</body>
</html>

<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="P01_SignIn.aspx.cs" Inherits="GWA.PageWorks.P01_Main" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div id="divSignInForm" style="width:30%; height:40%; display:inline-block; position:fixed;">
            <div>
                <asp:Label runat="server">アカウント名</asp:Label>
            </div>
            <div>
                <asp:TextBox runat="server" ID="tbAccountName"/>
            </div>
            <div>
                <asp:Label runat="server">パスワード</asp:Label>
            </div>
            <div>
                <asp:TextBox runat="server" TextMode="Password" ID="tbPassword"/>
                
            </div>
            <div>
                <asp:Label runat="server" ID="lblLoginFailedMessage">ID、またはパスワードをもう一度確認してください。</asp:Label>
            </div>
            <div>
                <asp:Button runat="server" Text="サインイン" ID="btnSignIn" OnClick="btnSignIn_Click"/>
            </div>
            <div>
                <div>
                    <asp:Button runat="server" Text="パスワード変更" />
                    <asp:Button runat="server" Text="会員登録" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>

<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="P06_AccountManagementPage.aspx.cs" Inherits="GWA.PageWorks.P06_AccountManagementPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>アカウント管理</title>
    <script type="text/javascript" charset="utf-8">
        function displayDivAddAccount() {
            document.getElementById("divAddAccount").style.display = "inline-block";
            document.getElementById("btnAddAccount").style.display = "none";
        }
        function hideDivAddAccount() {
            document.getElementById("divAddAccount").style.display = "none";
            document.getElementById("btnAddAccount").style.display = "inline-block";
        }

        function displayUpdateDiv(rowIndex) {
            document.getElementById("divUpdateArea").style.display = "inline-block";
            document.getElementById("tbNewAccountType").textContent = document.getElementById("gvAllAccountInfo_lblAccountType_" + rowIndex).innerText;
        }

        function hideUpdateDiv() {
            document.getElementById("divUpdateArea").style.display = "none";
        }
    </script>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Button runat="server" ID="btnToAdminPage" Text="戻る" OnClick="btnToAdminPage_Click" />
            <button id="btnAddAccount" onclick="JavaScript:displayDivAddAccount(); return false;">アカウント追加</button>
        </div>
        <div>
            <div id="divAddAccount" style="display: none;">
                <table style="border: thin solid blue; width: 100%;">
                    <tr>
                        <td>
                            <h4>アカウント名：</h4>
                        </td>
                        <td>
                            <asp:TextBox runat="server" ID="tbNewAccount_AccountName"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>
                            <h4>パスワード：</h4>
                        </td>
                        <td>
                            <asp:TextBox runat="server" ID="tbNewAccount_Password" TextMode="Password"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>
                            <h4>パスワード確認：</h4>
                        </td>
                        <td>
                            <asp:TextBox runat="server" ID="tbNewAccount_PasswordConfirm" TextMode="Password"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>
                            <h4>姓名（姓）：</h4>
                        </td>
                        <td>
                            <asp:TextBox runat="server" ID="tbNewAccount_FirstName"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>
                            <h4>姓名（名）：</h4>
                        </td>
                        <td>
                            <asp:TextBox runat="server" ID="tbNewAccount_LastName"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>
                            <h4>メールアドレス：</h4>
                        </td>
                        <td>
                            <asp:TextBox runat="server" ID="tbNewAccount_EmailAddress" TextMode="Email"></asp:TextBox></td>
                    </tr>
                </table>

                <asp:Button runat="server" ID="btnConfirmNewAccount" Text="アカウント登録" OnClick="btnConfirmNewAccount_Click" />
                <button id="btnCancelAddAccount" onclick="JavaScript:hideDivAddAccount(); return false;">キャンセル</button>
            </div>

            <asp:GridView
                runat="server" ID="gvAllAccountInfo" Visible="true" AutoGenerateColumns="false" BackColor="White"
                BorderColor="#3366CC" BorderStyle="None" BorderWidth="1px" CellPadding="4"
                OnPageIndexChanging="gvAllAccountInfo_PageIndexChanging"
                OnRowCancelingEdit="gvAllAccountInfo_RowCancelingEdit"
                OnRowDataBound="gvAllAccountInfo_RowDataBound"
                OnRowDeleting="gvAllAccountInfo_RowDeleting"
                OnRowEditing="gvAllAccountInfo_RowEditing"
                OnRowUpdating="gvAllAccountInfo_RowUpdating"
                OnSorting="gvAllAccountInfo_Sorting
                ">

                <RowStyle BackColor="White" ForeColor="#003399" />
                <Columns>

                    <asp:CommandField ShowEditButton="false" />

                    <asp:CommandField ShowDeleteButton="true" />
                    <asp:BoundField DataField="AccountName" HeaderText="アカウント名" ReadOnly="True" SortExpression="AccountName" />

                    <asp:TemplateField HeaderText="アカウントタイプ" SortExpression="AccountType">
                        <EditItemTemplate>
                            <asp:TextBox ID="tbAccountType" runat="server" Text='<%# Bind("AccountType") %>' ViewStateMode="Enabled"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="lblAccountType" runat="server" Text='<%# Bind("AccountType") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="名前（姓）" SortExpression="FirstName">
                        <EditItemTemplate>
                            <asp:TextBox ID="tbFirstName" runat="server" Text='<%# Bind("FirstName") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="lblFirstName" runat="server" Text='<%# Bind("FirstName") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="名前（名）" SortExpression="LastName">
                        <EditItemTemplate>
                            <asp:TextBox ID="tbLastName" runat="server" Text='<%# Bind("LastName") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="lblLastName" runat="server" Text='<%# Bind("LastName") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="メール" SortExpression="Email">
                        <EditItemTemplate>
                            <asp:TextBox ID="tbEmail" runat="server" Text='<%# Bind("Email") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="lblEmail" runat="server" Text='<%# Bind("Email") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="自宅住所" SortExpression="HomeAddress">
                        <EditItemTemplate>
                            <asp:TextBox ID="tbHomeAddress" runat="server" Text='<%# Bind("HomeAddress") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="lblHomeAddress" runat="server" Text='<%# Bind("HomeAddress") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="職場" SortExpression="WorkPlace">
                        <EditItemTemplate>
                            <asp:TextBox ID="tbWorkPlace" runat="server" Text='<%# Bind("WorkPlace") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="lblWorkPlace" runat="server" Text='<%# Bind("WorkPlace") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <button id="btnOpenUpdateDiv" onclick="displayUpdateDiv(this.parentNode.parentNode.rowIndex-1); return false;">編集</button>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div id="divUpdateArea" style="display: none;">

            <table>
                <tr>
                    <td>
                        <label>アカウントタイプ：</label>
                    </td>
                    <td>
                        <asp:TextBox runat="server" ID="tbNewAccountType"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>姓名（姓）：</label>
                    </td>
                    <td>
                        <asp:TextBox runat="server" ID="tbNewFirstName"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>姓名（名）：</label>
                    </td>
                    <td>
                        <asp:TextBox runat="server" ID="tbNewLastName"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>メールアドレス：</label>
                    </td>
                    <td>
                        <asp:TextBox runat="server" ID="tbNewMail"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>自宅住所：</label>
                    </td>
                    <td>
                        <asp:TextBox runat="server" ID="tbNewHomeAddress"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>職場：</label>
                    </td>
                    <td>
                        <asp:TextBox runat="server" ID="tbNewWorkPlace"></asp:TextBox>
                    </td>
                </tr>
            </table>
            <asp:Button runat="server" ID="btnUpdateInfo" Text="編集登録" />
            <button id="btnCancelUpdate" onclick="hideUpdateDiv(); return false;">キャンセル</button><br />
        </div>

    </form>
</body>
</html>

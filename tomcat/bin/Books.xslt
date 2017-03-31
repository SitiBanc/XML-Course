<?xml version="1.0" encoding="Big5"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
    <head><title>迴圈顯示圖書資料</title></head>
    <body>
    <center><h2>電腦圖書資料</h2></center><hr/>
    <table width="100%" border="1">
    <thead>
        <th>書號</th><th>書名</th>
        <th>作者</th><th>定價</th>
    </thead>
    <tbody>
    <xsl:for-each select="library/book">
        <tr>
        <td><xsl:value-of select="@code"/></td>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="author"/></td>
        <td><xsl:value-of select="price"/></td>
        </tr>
    </xsl:for-each>
    </tbody>
    </table>
    </body>
    </html>
</xsl:template>
</xsl:stylesheet>
<?xml version="1.0" encoding="Big5"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
    <head><title>�j����ܹϮѸ��</title></head>
    <body>
    <center><h2>�q���ϮѸ��</h2></center><hr/>
    <table width="100%" border="1">
    <thead>
        <th>�Ѹ�</th><th>�ѦW</th>
        <th>�@��</th><th>�w��</th>
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
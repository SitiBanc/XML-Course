<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/messages">
	<html>
		<body>
			<xsl:for-each select="message[@lang='zh']">
				<xsl:value-of select="."/><br/>
			</xsl:for-each>
		</body>
	</html>
	</xsl:template>
</xsl:stylesheet>
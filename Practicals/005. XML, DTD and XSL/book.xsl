<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>Book Collection</h3>
                <link rel="stylesheet" type="text/css" href="book.css"/>
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Publisher</th>
                        <th>Year</th>
                        <th>Price</th>
                    </tr>
                    <xsl:for-each select="bookstore/book">
                        <tr>
                            <td><xsl:value-of select="title"></xsl:value-of></td>
                            <td><xsl:value-of select="author"></xsl:value-of></td>
                            <td><xsl:value-of select="publisher"></xsl:value-of></td>
                            <td><xsl:value-of select="year"></xsl:value-of></td>
                            <td><xsl:value-of select="price"></xsl:value-of></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

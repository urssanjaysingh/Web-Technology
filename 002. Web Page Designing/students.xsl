<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>

            <head>
                <title>Student Information</title>
                <style>
                    table {
                        border-collapse: collapse;
                        width: 100%;
                    }

                    th,
                    td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: left;
                    }

                    th {
                        background-color: #f2f2f2;
                    }
                </style>
            </head>

            <body>
                <h1>Student Information</h1>
                <table>
                    <tr>
                        <th>Roll Number</th>
                        <th>Name</th>
                        <th>Mathematics</th>
                        <th>Physics</th>
                        <th>Chemistry</th>
                        <th>English</th>
                        <th>Computer Science</th>
                        <th>Total Marks</th>
                        <th>Percentage</th>
                    </tr>
                    <xsl:for-each select="students/student">
                        <tr>
                            <td><xsl:value-of select="rollNumber" /></td>
                            <td><xsl:value-of select="name" /></td>
                            <td><xsl:value-of select="marks[subject='Mathematics']/obtained" /></td>
                            <td><xsl:value-of select="marks[subject='Physics']/obtained" /></td>
                            <td><xsl:value-of select="marks[subject='Chemistry']/obtained" /></td>
                            <td><xsl:value-of select="marks[subject='English']/obtained" /></td>
                            <td><xsl:value-of select="marks[subject='Computer Science']/obtained" /></td>
                            <td><xsl:value-of select="totalMarks" /></td>
                            <td><xsl:value-of select="percentage" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>

        </html>
    </xsl:template>
</xsl:stylesheet>
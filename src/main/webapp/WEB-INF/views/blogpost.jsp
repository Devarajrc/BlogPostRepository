<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Blog Post Page</title>
        </head>
        <body>
            <form:form id="blogForm" modelAttribute="blog" action="BlogProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="title">Title: </form:label>
                        </td>
                        <td>
                            <form:input path="title" name="title" id="title" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="desc">Description:</form:label>
                        </td>
                        <td>
                            <form:password path="desc" name="desc" id="desc" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="blog" name="blog">Blog</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                       
                    </tr>
                </table>
            </form:form>
            <table align="center">
                
            </table>
        </body>
        </html>

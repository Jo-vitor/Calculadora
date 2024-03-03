package br.vianna;

import br.vianna.model.Calculadora;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/primeiroServlet")
public class PrimeiroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resposta(req, resp);
    }

    private void resposta(HttpServletRequest req, HttpServletResponse resp) {
        String v1 = req.getParameter("cpValor1");
        String v2 = req.getParameter("cpValor2");
        String btn = req.getParameter("btn");

        Calculadora c = new Calculadora();
        c.setValor1(Integer.parseInt(v1));
        c.setValor2(Integer.parseInt(v2));
        c.setOperador(btn);

        DecimalFormat dc = new DecimalFormat("#,##0.00");

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Calculadora</title>\n" +
                "    <link rel=\"stylesheet\" href=\"./css/style.css\">\n" +
                "</head>\n" +
                "<body >\n" +
                "    <div class=\"div-principal\">\n" +
                "        <h2>Calculadora</h2>\n" +
                "        <form action=\"/primeiroServlet\" method=\"get\">\n" +
                "            <label for=\"\">Valor 1</label> <input type=\"number\" name=\"cpValor1\">\n" +
                "            <label for=\"\">Valor 2</label> <input type=\"number\" name=\"cpValor2\">\n" +
                "\n" +
                "            <button value=\"+\" name=\"btn\" type=\"button\"> + </button>\n" +
                "            <button value=\"-\" name=\"btn\" type=\"button\"> - </button>\n" +
                "            <button value=\"/\" name=\"btn\" type=\"button\"> / </button>\n" +
                "            <button value=\"*\" name=\"btn\" type=\"button\"> x </button>\n" +
                "        </form>\n" +
                "        <h4>Resultado:</h4>\n" +
                "        <h3>"+ req.getParameter("cpValor1")+ " " + req.getParameter("btn") + " " + req.getParameter("cpValor2") + " = " + dc.format(c.operacao()) +"</h3>\n" +
                "    </div>\n" +
                "    \n" +
                "    <script src=\"./js/Ajax.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        try {
            resp.getWriter().print(html);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resposta(req, resp);
    }
}

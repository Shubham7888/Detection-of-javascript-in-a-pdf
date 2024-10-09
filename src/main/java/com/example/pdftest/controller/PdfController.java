package com.example.pdftest.controller;

import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class PdfController {

    @PostMapping("/checkPdfForJavascript")
    public String checkPdfForJavascript(@RequestBody String base64EncodedFile) {

       // System.out.println("Cleaned Base64 String: " + base64EncodedFile);

      // base64EncodedFile="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OToyNToxMiswMjowMDwveG1wOk1vZGlmeURhdGU+CiAgICAgICAgIDx4bXA6Q3JlYXRlRGF0ZT4yMDE3LTA2LTA4VDE2OjEzOjQ3KzAyOjAwPC94bXA6Q3JlYXRlRGF0ZT4KICAgICAgICAgPHhtcDpNZXRhZGF0YURhdGU+MjAxNy0wNi0wOFQxOToyNToxMiswMjowMDwveG1wOk1ldGFkYXRhRGF0ZT4KICAgICAgICAgPHhtcDpDcmVhdG9yVG9vbD5BZG9iZSBBY3JvYmF0IFBybyBEQyAxNy45LjIwMDQ0PC94bXA6Q3JlYXRvclRvb2w+CiAgICAgICAgIDxkYzpmb3JtYXQ+YXBwbGljYXRpb24vcGRmPC9kYzpmb3JtYXQ+CiAgICAgICAgIDxkYzpkZXNjcmlwdGlvbj4KICAgICAgICAgICAgPHJkZjpBbHQ+CiAgICAgICAgICAgICAgIDxyZGY6bGkgeG1sOmxhbmc9IngtZGVmYXVsdCI+aHR0cHM6Ly9naXRodWIuY29tL21hdHRpYXMtb2hsc3Nvbi9laWNhci1zdGFuZGFyZC1hbnRpdmlydXMtdGVzdC1maWxlczwvcmRmOmxpPgogICAgICAgICAgICA8L3JkZjpBbHQ+CiAgICAgICAgIDwvZGM6ZGVzY3JpcHRpb24+CiAgICAgICAgIDx4bXBNTTpEb2N1bWVudElEPnV1aWQ6OTgwY2Q3ZDQtYzg2OC00ODY0LTg3M2YtZTMyODBhMTIwM2I1PC94bXBNTTpEb2N1bWVudElEPgogICAgICAgICA8eG1wTU06SW5zdGFuY2VJRD51dWlkOjY2NzhlMjVlLTY1MWEtNGVlMC1iZjNiLWVlY2NhNTAwZWJjZjwveG1wTU06SW5zdGFuY2VJRD4KICAgICAgICAgPHBkZjpQcm9kdWNlcj5BZG9iZSBBY3JvYmF0IFBybyBEQyAxNy45LjIwMDQ0PC9wZGY6UHJvZHVjZXI+CiAgICAgICAgIDxwZGY6S2V5d29yZHMvPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgIAo8P3hwYWNrZXQgZW5kPSJ3Ij8+DQplbmRzdHJlYW0NZW5kb2JqDTQgMCBvYmoNPDwvRmlsdGVyL0ZsYXRlRGVjb2RlL0ZpcnN0IDE3L0xlbmd0aCAxNDkvTiAzL1R5cGUvT2JqU3RtPj5zdHJlYW0NCmjeXI0xC8IwFITfT3ljs/Q1FYpDyaJmEUREp+JQ0ocUmqSQBOqfV2PdHA4O7rs7WWGFUuKmQVnjtsa2pZ1PLqKk4ziETjYZuNzp+pyZzv2Dg1KZOfWWQ1e83jCABwMJLDA4iFBmLRBFnvsWV3rPwRSCDjp7jWugFOli8CZZdrGMSxS/Cz1OHGY2dPuLlfoIMACQ1TExDQplbmRzdHJlYW0NZW5kb2JqDTUgMCBvYmoNPDwvRmlsdGVyL0ZsYXRlRGVjb2RlL0ZpcnN0IDUvTGVuZ3RoIDE4Ny9OIDEvVHlwZS9PYmpTdG0+PnN0cmVhbQ0KaN6MzMFqwkAQgOFX2ZsJstnZNTUqIoi5lUKhTzDZnTYrmpGdidK3b6HQQ0+9///nVwbMfu9OhVAzTz0qVf0ugO9gDRu/9qu2W0JYACzqn4pLdUw8kDnGwgOqeS1s+pPxXbNtAkDb1u6ZPh9cklS1e+H0F92GJx9+0e89zZH+ob7Nw5miVqPqTXbOfWQd56GJfHVXVM0olseLCE+OcsRiRXFKWJLFSfM9l1mskqh9zxeS+nD4EmAABJhN7g0KZW5kc3RyZWFtDWVuZG9iag02IDAgb2JqDTw8L0RlY29kZVBhcm1zPDwvQ29sdW1ucyA0L1ByZWRpY3RvciAxMj4+L0ZpbHRlci9GbGF0ZURlY29kZS9JRFs8Q0Y2NUIwNTg5MjI3OTU0M0E4MzgzMjcwNTlFRTQ4RUE+PDhGNkIyNUQ5MzQyNkIxNDc5NEEyMzI0MjI0RUZDOEJFPl0vSW5mbyAxMyAwIFIvTGVuZ3RoIDUyL1Jvb3QgMTUgMCBSL1NpemUgMTQvVHlwZS9YUmVmL1dbMSAyIDFdPj5zdHJlYW0NCmjeYmIAAiZGNl8GJgbG2yBCGkjwbgexPgMJJgmg7Is/QBYDAyOMYP6HwmX8BxBgAO4hByQNCmVuZHN0cmVhbQ1lbmRvYmoNc3RhcnR4cmVmDQoxMTYNCiUlRU9G"; 
                      
              

        if (base64EncodedFile.startsWith("data:application/pdf;base64,")) {
            base64EncodedFile = base64EncodedFile.substring(base64EncodedFile.indexOf(",") + 1);
        }

        String cleanedBase64EncodedFile = base64EncodedFile.replaceAll("\\s+", "");

        while (cleanedBase64EncodedFile.length() % 4 != 0) {
            cleanedBase64EncodedFile += "=";
        }

        try {

            byte[] pdfBytes = Base64.getDecoder().decode(cleanedBase64EncodedFile);


            String pdfContent = new String(pdfBytes, StandardCharsets.ISO_8859_1);

            System.out.println(pdfContent);

            if (pdfContent.contains("/JS") ||
                    pdfContent.contains("/JavaScript") ||
                    pdfContent.contains("/AA") ||
                    pdfContent.contains("<script") ||
                    pdfContent.contains("</script>") ||
                    pdfContent.contains("/Launch") ||
                    pdfContent.contains("/OpenAction") ||
                    pdfContent.contains("/AA") ||
                    pdfContent.contains("/ResetForm") ||
                    pdfContent.contains("%PDF-\\d\\.\\d") ||
                    pdfContent.contains("/Filter\\s*/FlateDecode") ||
                    pdfContent.contains("/Type\\s*/ObjStm") ||
                    pdfContent.contains("startxref[\\s\\S]+%%EOF") ||
                    pdfContent.contains("/URI\\s*\\(.*?\\)") ||
                    pdfContent.contains("/xmpmeta|rdf:Description") ||

                    pdfContent.contains("<submit") ||
                   pdfContent.contains("target=\"") ||
                   pdfContent.contains("docReady") ||
                   pdfContent.contains("<event") ||
                   pdfContent.contains("/AcroForm") ||
                   pdfContent.contains("/XFA") ||
                   pdfContent.contains("<template") ||
                   pdfContent.contains("xfa") ||
                   pdfContent.contains("xdpContent") ||
                   pdfContent.contains("UTF-16") ||

                    pdfContent.contains("eval(atob(")||
                    pdfContent.contains("btoa(")||
                    pdfContent.contains("String.fromCharCode(")||
                    pdfContent.contains("decodeURIComponent(")||
                    pdfContent.contains("escape(")||
   
                    pdfContent.contains("/AcroForm") ||
                    pdfContent.contains("/SubmitForm") ||
                    pdfContent.contains("/RichMedia") ||
                    pdfContent.contains("/EmbeddedFile") ||
                    pdfContent.contains("/URI") ||
                    pdfContent.contains("<iframe")||
                    pdfContent.contains("iframe src=")||
                    pdfContent.contains("document.write(")||
                    pdfContent.contains("innerHTML")||
                    pdfContent.contains("<link rel='javascript'")||
                   pdfContent.contains("/FileAttachment") ||
                    pdfContent.contains("/GotoR") ||
                    pdfContent.contains("/Named") ||
                    pdfContent.contains("/Action") ||
                    pdfContent.contains("/XFA") ||
                    pdfContent.contains("eval(") ||
                    pdfContent.contains("new Function(") ||
                    pdfContent.contains("function ") || 
                    pdfContent.contains("console.") ||
                    pdfContent.contains("window.") ||
                    pdfContent.contains("document.") ||
                    pdfContent.contains("alert(") ||
                    pdfContent.contains("confirm(") ||
                    pdfContent.contains("prompt(") ||
                    pdfContent.contains("setTimeout(") ||
                    pdfContent.contains("setInterval(") ||
                    pdfContent.contains("addEventListener(") ||
                    pdfContent.contains("XMLHttpRequest") ||
                    pdfContent.contains("onload=")||
                    pdfContent.contains("onclick=")||
                    pdfContent.contains("onmouseover=")||
                    pdfContent.contains("onfocus=")||
                    pdfContent.contains("onerror=")||
                    pdfContent.contains("onblur=")||
                    pdfContent.contains("onsubmit=")||
                    pdfContent.contains("onchange=")||
                    pdfContent.contains("onkeydown=")||
                    pdfContent.contains("onkeyup=")||
                    pdfContent.contains("onkeypress=")||
                    pdfContent.contains("onresize=")||
                    pdfContent.contains("execScript(")||
                    pdfContent.contains("setImmediate(")||
                    pdfContent.contains("ScriptEngine(")||
                    pdfContent.contains("escape(")||
                    pdfContent.contains("unescape(")||
                    pdfContent.contains("decodeURI(")||
                    pdfContent.contains("decodeURIComponent(")||
                    pdfContent.contains("unescape(")||
                    pdfContent.contains("javascript:") ||
                    pdfContent.contains("data:text/javascript,")) {
                // Handle the presence of JavaScript code
                return "Potential malicious content found in the PDF!";
            } else {
                return "No malicious content found in the PDF.";
            }

        } catch (IllegalArgumentException e) {

            System.err.println("Error decoding Base64: " + e.getMessage());
            return "Invalid Base64 input: " + e.getMessage();
        }
    }
}

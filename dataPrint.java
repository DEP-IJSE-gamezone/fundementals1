public class demo13 {
    void main() {
        // to bold  - - > ;1
        final String BLUE = "\033[34;1m";
        final String RESET = "\033[0m";
        String data = """
                5-Kasun Sampath-Galle,
                2-Amil Shantha-Panadura,
                250-Ruwani-Matara,
                11-Supun-Panadura
                """;


        data = data.replace("\n", "");
        int count = data.isBlank() ? 0 : data.length() - data.replace(",", "").length() + 1;
        String ids = "", names = "", addresses = "";
        int commaIndex = 0;
        int nameLength = 6;
        int addressLength = 9;
        int totalLength = nameLength + addressLength + 5 + 4;

        String datatable = "";
        for (int i = 0; i < count; i++) {

            String studentDetail = data.substring(commaIndex, (i == (count - 1)) ? data.length() : data.indexOf(",", commaIndex));
            commaIndex = data.indexOf(",", commaIndex) + 1;
            int firstHypenIndex = studentDetail.indexOf("-");
            int lastHypenIndex = studentDetail.lastIndexOf("-");
            String id = String.format("S%03d", Integer.parseInt(studentDetail.substring(0, firstHypenIndex)));
            String name = studentDetail.substring(firstHypenIndex + 1, lastHypenIndex);
            String address = studentDetail.substring(lastHypenIndex + 1);

            if (name.length() > nameLength) nameLength = name.length();
            if (address.length() > addressLength) addressLength = address.length();


            ids += STR."\{id}+";
            names += STR."\{name}+";
            addresses += STR."\{address}+";


//                int hypenIdex=studentDetail.indexOf("-");
//                String id=studentDetail.substring(0,hypenIdex++);
//                String name=studentDetail.substring(hypenIdex,hypenIdex=studentDetail.indexOf("-",hypenIdex));
//                String addres=studentDetail.substring(++hypenIdex);
//                System.out.println(studentDetail);

        }


        final String LINE = "+".concat("-".repeat(5)).concat("+").concat("-".repeat(nameLength))
                .concat("+").concat("-".repeat(addressLength)).concat("+");
        System.out.println(LINE);

        System.out.printf("%s" + BLUE + "%-5s" + RESET + "%s" + BLUE + "%-" + nameLength + "s" + RESET + "%s" + BLUE + "%-"
                + addressLength + "s" + RESET + "%s\n", "|", " ID", "|", "  NAME", "|", "ADDRESS", "|");
        String strWithoutColor = "%s%-5s%s%-" + nameLength + "s%s%-" + addressLength + "s%s\n";

        System.out.println(LINE);

        totalLength = nameLength + addressLength + 5 +2;
        int plusIndexId = 0;
        int plusIndexName = 0;
        int plusIndexAddress = 0;

        for (int i = 0; i < count; i++) {
            int hypenIndexId = ids.indexOf("+", plusIndexId);
            String id = ids.substring(plusIndexId, hypenIndexId);
            plusIndexId = hypenIndexId + 1;

            int hypenIndexName = names.indexOf("+", plusIndexName);
            String name = names.substring(plusIndexName, hypenIndexName);
            plusIndexName = hypenIndexName + 1;

            int hypenIndexAddress = addresses.indexOf("+", plusIndexAddress);
            String address = addresses.substring(plusIndexAddress, hypenIndexAddress);
            plusIndexAddress = hypenIndexAddress + 1;

            //  "|%05s|%-NAMELENs|%-ADDRESSLENs";
            System.out.printf("%s" + BLUE + "%-5s" + RESET + "%s" + BLUE + "%-" + nameLength + "s" + RESET + "%s" + BLUE + "%-" + addressLength + "s" + RESET + "%s\n", "|", id, "|", name, "|", address, "|");
        }
        if (count == 0) {
            System.out.printf("|%-"+(totalLength)+"s|\n","  NO DATA AVAILABLE");
        }

        System.out.println(LINE);



    }
}

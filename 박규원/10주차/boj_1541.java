import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String equation = br.readLine();
        StringBuilder sb = new StringBuilder(equation);

        int plusValue = 0;
        int minusValue = 0;
        String value = "";
        boolean status = true;

        for(int i=0;i<equation.length();i++){

            if(equation.charAt(i) == '-'){
                if(status) plusValue += Integer.parseInt(value);
                if(!status) minusValue += Integer.parseInt(value);    
        
                value = "";
                status = false;
                continue;
            }

            if(equation.charAt(i) == '+'){
                if(status){
                    plusValue += Integer.parseInt(value);
                    value = "";
                }

                if(!status){
                    minusValue += Integer.parseInt(value);
                    value = "";
                }

                continue;
            }

            value += Character.toString(equation.charAt(i));
        }

        if(!status) minusValue += Integer.parseInt(value);
        if(status) plusValue += Integer.parseInt(value);

        System.out.println(plusValue - minusValue);
    }
}
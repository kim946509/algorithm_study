import java.io.*;
import java.util.*;

//암호만들기 - 백트래킹, 조합, 브루트포스

//자음 최소 2개 뽑고, 모음 최소 1개 뽑아서 l개를 만든다 (조합으로 각 모음과 자음을 선택)

//뽑은 자음과 모음을 합친다. 그리고 정렬한다. => 비밀번호 1개 생성

//만든 비밀번호 후보들이 여러가지 나올건데 이것들을 정렬한다 => 정답

class Main {
    public static ArrayList<Character> vowel = new ArrayList<>();
    public static ArrayList<Character> consonant = new ArrayList<>();

    public static ArrayList<Character> vowel_answer = new ArrayList<>();
    public static ArrayList<Character> consonant_answer = new ArrayList<>();

    public static ArrayList<String> vowel_answer_for_merge = new ArrayList<>();
    public static ArrayList<String> consonant_answer_for_merge = new ArrayList<>();

    public static ArrayList<String> total_answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<c;i++){
            char ch = st.nextToken().charAt(0);

            if(check_vowel(ch)){
                vowel.add(ch);
            }else{
                consonant.add(ch);
            }
        }

        for(int i=1;i<=vowel.size();i++){

            if(l-i <2) break; //만약에 a,b,c,d,e,f 에서 l=3, c=6일때, 모음 2개 뽑으면 자음을 1개 뽑는 상황이 오니깐 (자음은 최소 2개) 그런 케이스는 필요없으니 반복문 탈출
            
            vowel_select(i, 0);
            consonant_select(l-i, 0);

            for(String v_a : vowel_answer_for_merge){
                for(String c_a : consonant_answer_for_merge){
                    char[] sum = (v_a + c_a).toCharArray();
                    Arrays.sort(sum);
                    total_answer.add(new String(sum));
                }
            }

            vowel_answer_for_merge.clear();
            consonant_answer_for_merge.clear();

            vowel_answer.clear();
            consonant_answer.clear();
        }
        
        Collections.sort(total_answer);

        for(String t_a : total_answer){
            System.out.println(t_a);
        }
    }

    //모음을 최소 1개 선택
    public static void vowel_select(int number, int idx){
        if(vowel_answer.size() == number){
            String s ="";
            for(char c : vowel_answer){
                s+= (c + "");
            }
            vowel_answer_for_merge.add(s);
            return;
        }

        for(int i=idx;i<vowel.size();i++){
            vowel_answer.add(vowel.get(i));
            vowel_select(number, i+1);
            vowel_answer.remove(vowel_answer.size()-1);
        }
    }  

    //자음을 최소 2개 선택
    public static void consonant_select(int number, int idx){
        if(consonant_answer.size() == number){
            String s = "";
            for(char c : consonant_answer){
                s+= (c + "");
            }
            consonant_answer_for_merge.add(s);
            return;
        }

        for(int i=idx;i<consonant.size();i++){
            consonant_answer.add(consonant.get(i));
            consonant_select(number, i+1);
            consonant_answer.remove(consonant_answer.size()-1);
        }
    }

    //모음인지 자음인지 판정
    public static boolean check_vowel(char c){
        if(c == 'a' || c == 'e' || c =='i' || c=='o' || c=='u'){
            return true;
        }

        return false;
    }

}
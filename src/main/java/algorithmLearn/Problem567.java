package algorithmLearn;

import Top100.Problem38;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int l = find_and_map(0, map, s1, s2);
        if (l == -1) return false;
        int r = l + s1.length() - 1;
        while (r < s2.length()) {
            boolean flag = true;
            for (int i : map.values()) {
                if (i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) return true;
            else {
                if (r + 1 == s2.length()) return false;
                else if (map.containsKey(s2.charAt(r + 1))) {
                    int temp1 = map.get(s2.charAt(l));
                    map.remove(s2.charAt(l));
                    map.put(s2.charAt(l), temp1 + 1);

                    int temp2 = map.get(s2.charAt(r + 1));
                    map.remove(s2.charAt(r + 1));
                    map.put(s2.charAt(r + 1), temp2 - 1);
                    l++;
                    r++;
                } else if (!map.containsKey(s2.charAt(r + 1))) {
                    l = find_and_map(r + 2, map, s1, s2);
                    r = l + s1.length() - 1;
                    if (l == -1) return false;
                }
            }
        }
        return false;
    }

    public int find_and_map(int l, Map<Character, Integer> map, String s1, String s2) {
        map.clear();
        for (int i = 0; i < s1.length(); i++) {
            if (!map.containsKey(s1.charAt(i))) map.put(s1.charAt(i), 1);
            else {
                int temp = map.get(s1.charAt(i));
                map.remove(s1.charAt(i));
                map.put(s1.charAt(i), temp + 1);
            }
        }

        while (l <= s2.length() - s1.length()) {
            boolean flag = true;
            for (int i = l; i < l + s1.length(); i++) {
                if (!map.containsKey(s2.charAt(i))) {
                    l = i + 1;
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
        }
        int r = l + s1.length() - 1;
        if (r >= s2.length()) return -1;
        for (int i = l; i <= r; i++) {
            if (map.containsKey(s2.charAt(i))) {
                int temp = map.get(s2.charAt(i));
                map.remove(s2.charAt(i));
                map.put(s2.charAt(i), temp - 1);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Problem567 p = new Problem567();
        System.out.println(p.checkInclusion("nb", "tjgrhzhzwaovnvhvwtomgtqkqutufhkghqzudxrhsqoyklhixjhwaqxawcntspwbpykidlnvempggnmmltgzsnsfppguphrtvjorsbsrksmxuorijwlqilnzejbzgztjusnnpbsudcbnhydkumwbrlbwcwsujqgcobezsmgfatdasnwcainwjrpqxyqsitbzcfrwsndsvlcxvkujgjqhnoocxpwnbcpqbxyuuxqaqqoxjvyycufyjhbcgqegxljupwizchlwscczlszjepkopoalhpofmhagdanhclbtlcyxqhkoogymnoakznszzkxzohhmyixhlrdisohwzzhbclxedlgyfhrrbvmehaaksgovfecxxfnmhspneboziyokydatocaukehpiicthcjuapgeaohuxaftonsjxzdnjkjjhorbkplkhsmbjharpchcivxdcezxdqwzpedmmanqhrwsycxbhbeaqezixyxckeakmnoztrlpqdiairweimlfzwpefxejzlkxchutqzgtxjrovwlvrqzcksvrpmpsffdkuihacouiusoynzqwznisznxjsajuetramqfvrspazalpkqfromorffnupblqkfngbefndwbycmzbctswzjzvxqwcbcczrdnwctvhoccsnbjybmmtvhtsmjnryrqqefszeqbvhtlxuqumqdsnjlqbeqtmtbjtkilgyeuiizwnevxvuryanbancehacxilalknwqitkrkwazlpdkiszecqqewezvnhefkgjdlcpntqlitlpykefffoizpohzqmlgktmykhykwbzqkhwhobvlfbzhsngczdqexpnihlcujlkgnfuejhnrpxxhdbworsafpexnzfsdarldochahifyctawnatidaxrtfufwjxzxpsqwwguqktpwrrqzsqyoeeydjppknulaibguahgblamokqcivsbscjwvbxfatetequvfmxlrhdyqbzisvgxoaghuovbkeocdgpelqyfhdvlvsafrocrsmmyndtcwibdpqyjxgnquytyiboqvpzuwkqarmssmptkaucxjzrmwxaehekbmieqzlopxatquffvyfeoglflihxwpjdtixpmamlnahybjcwgzwrjqzejjnvnhzvvwcoxipfcsjnlrvrezrltakupmsexaokxucatsprgqtwkkyupofzhyymgqegvklnwoixqulzdgxkmyqldowzhpwqlejowdtdagsfzglykhvjjprstgozwvsivewrpirqoykqaitgcswfljpjbxjwvtgzpxcdyrrsnspfmgasaccamheuvhczyxswdftgrzidzqyoqyyiccgbggkrqcxtzfdqngofnvxomaksryrimuksuapijqlgfbnodgtkteomcqnezoaupcabhczusaiaitxwtlekcnzzgwlzgzrxtlxjeyojocqogdzahtzqjpovukbbekolnhbnvscrqhxwngqnktfvyflxwbhmrkcjmqxkqwpnqbfzbyqeypdikozemtfdhoeoymkfuwpabjjjfnqqvekjqyzwgctytcjzkluuzmtaasmpgxnydnfetcxrrrvwznvzmfgosampdpnzjbyjngasgepdwzyctkdzvcyqxpnkoelwhnzjnzqjimlzveivgyzkvdejguefdypjidzupkcmwgoavwikawmifojsalmjbxcdzvhsharuhqzfuozmlokbmvussuvlradksbcrnvpeykmgmotiwrfposqghbgixkrzlqmuzquvczcknwxxmo"));
    }
}

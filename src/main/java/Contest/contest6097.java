package Contest;
import java.util.*;

public class contest6097 {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < mappings.length; i++) {
            if (!map.containsKey(mappings[i][0])) {
                Set<Character> set = new HashSet<>();
                set.add(mappings[i][1]);
                map.put(mappings[i][0], set);
            } else {
                Set<Character> set = map.get(mappings[i][0]);
                set.add(mappings[i][1]);
                map.put(mappings[i][0], set);
            }
        }
        HashSet<Character> sets[] = new HashSet[sub.length() + 1];

        for(int i = 0; i < sub.length(); i++){
            HashSet<Character> set = (HashSet<Character>) map.getOrDefault(sub.charAt(i), new HashSet<>());
            set.add(sub.charAt(i));
            sets[i] = set;
        }

        int p = 0;
        while (p <= s.length() - sub.length()) {
            System.out.println(p);
            boolean correct = true;
            for (int i = 0; i < sub.length(); i++) {
                if (sub.charAt(i) != s.charAt(p + i)) {
                    if(!sets[i].contains(s.charAt(i+p))){
                        correct = false;
                        break;
                    }
                }
            }
            if (correct) return true;
            p++;
        }
        return false;
    }

    public boolean matchReplacement2(String s, String sub, char[][] mappings) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();


        for(char[] mapx: mappings){
            HashSet<Character> set = map.getOrDefault(mapx[0], new HashSet<>());
            set.add(mapx[1]);
            map.put(mapx[0], set);
        }

        int m = sub.length();
        int n = s.length();

        HashSet<Character> sets[] = new HashSet[m + 1];

        for(int i = 0; i < m; i++){
            HashSet<Character> set = map.getOrDefault(sub.charAt(i), new HashSet<>());
            set.add(sub.charAt(i));
            sets[i] = set;
        }

        for(int i = 0; i < s.length(); i++){
            int j = i;

            while(j < n && j - i < m && sets[j - i].contains(s.charAt(j))){
                j++;
                System.out.println(String.valueOf(j)+" "+String.valueOf(i));
            }

            if(j - i == m) return true;
        }

        return false;
    }



    public static void main(String[] args) {
        contest6097 contest6097 = new contest6097();
        System.out.println(contest6097.matchReplacement("bmyrt0000xiin6wwkk9qfl6713kfuavayd2xvlir2wv7kttiifvjjl1rls67ogmri6z40scwdfmyviiue9znoqrcgyaiwlg3d207ps9fkc2u6jox5lhuazq16vyr0ow22t3i7frml2jkhe8ekl500til0y0jc3a3q2557zpuld3eyvu2w5pfyi2kihrdocj8zvjr3ghyv6mb0pzyv9ydiy3yk6jttdmsig40bxk2auqaqe41m8vya1sehftchf9ot69stauz3ncui5dx0pe879o3obw1ko0w9wrh3jsps7e4n2zb5sdj20xtvhe2wcplkigzeogo20mt1oczbdab1q9hq74nwfgntnugj4agws7200bpfdg30bthpryyyw5v79kzou404s3mbs7rcqjnhru11opxu79djd06khm7desb1e63z6kr6u1183tv9o1aovy5x68sdh3xq7q3u3ajob4zj8rodbwuxoazbddtejlu8q0ca43p8ioinpmuu630hvn0xq6n2swyzgsq78zwqjxeqxnfgumb06bu8ul230q8cguw894wptnpkqzy5rrpcdltgi78rmryfdtaqem49b3vvei15wyob3xhqp7fo6o33cv83r7q6owx6g4q64fluyvzy4ibhurct4ph5lscnj63rlblg79ixaqrzcd96bhefakren0tvq8f9jflx89rc797tk4hkcpzdlrr27cjxy23l43wa94x0n2vp8tycdwtfci5p4k3odfiolmwjb5fxpt4mmh930onljslkbftk3ucayfvvmn8tfxwsf93upd1xuzfteqy45kvfz4tnfd141fxkgluway9qk3fbohz4l0um0zf68blscp5tmirz2v5z2m6kkeki2pu5aqieyx6e2wh6jc07l5qttpnp5u4d4bk2gw44dugaoumkprcsczbczwsroug0e2h63ets78qf4xdoe9yiteewjw6908t2joatdv5gg8708choe0p7cvxrdrxhwuuwnnsuiuptf5ff2dt8uvt3ciuub0gczr8e56vdrwinp660az9d6nt733q7uccs54niu3y7sd7oag8rmneacxwglu5ryiscdwcf06hyqhyhm28onvf9wrs5w4o8knd4k050wh3qbetld2bjfzql6w13nrpajfkdufpzxh2id5j34jvr3azv556a6wz3kza8mjxdyp9q2y6v56r9bu6maj0esb5mxmvworvkgf5ikz6jxrh2v5b2hk970sge1man7smipk9ddrqwcezlzyxm8emgtgr35td6yzya4buyk67b5epn4rnpyn8letmx0wy3v0124a39oeic248py738jworlyhfndin4bbtgbqo7fdlte4zbtv0cncsp09wbiccdmr2cenvtfgauprpuc8",
                "yk6n8tdmei549bdkqaz8aqr4hv8jvahsrfftchf1o869s8az7knczi5md93r879okobw1ko9w1w1h3jepe7r4u2zb5ednq0dtjhr23c3lkigzrogoq0m81oczbmab181f874n3fgntuugn4ag3e7200b3am539b8f31vyyw5jp187ou404e3vbe71c8nuhru11o3xzp1dnd04khv7mrsbhe6374kr6zhh0k8j1ohaovv5d68edh3dq7qkukajob4zn81odbwuxoazbdmtenlz0q0ca4kp8noiupmuu4k9fvu0xq6n2s3yz5s8p8z38nxr8xnf5umb96bu0utqk9q8c5z30943ptu3k87y51r3cdt85np0rv1vad8a8rm41b3jjrn153vob3dhqp7ao4okkcv03r7q6owd454844fluyvzy4ibfz1c84ph5lecnn4krlbl5p9ixa81zcd96bfrfak1rn08jq0f1nfld01rcp9p8k4fkc37dtrr2pcndvq3l433a94d9nqjp88ycdwtfci5p4kkomaiolm3nb5adp84mvh939ontnslkbftk3ucavfvjmn08axwef13u3mhxz7fteqv45kjfz48uad141fdkgluway1qk3fbof74t0um0zf68blec358mnr7qv572m688e8n2pu5a8iryd6r2wh6nc07l58tt3n35u4d4b8q5w44mzgaouv831ceczbcz3srozg9eqh63etsp8qa4xdor9viteewn36100t2noatdj5558790cfor03pcvxrm1dhwzuwuusznup8a5aa2d80zjt3cnzub9gc710e54vd13nnp669a71m6n8pk387zccs54niu3y7ed7oag01muracxw5tu51yiecmwcf06hv8hyfm20oujf1w1s534o8knd4k950whk8betlm2bja7qt63h3n13ajakdua3zxh2nd5j34nvr3azv554a6wzkk7a8vnddy39qqv6v5611bu6vaj0eeb5vdmv3orj8gf5ik74jdrf2v5b2hk9p0sge1vaupevn381dd183crzl7ydm0rmgt51k58d4y7ya4bzvk47b5e3n41n",
                new char[][]{{'5', 'j'}, {'m', '8'}, {'r', 'y'}, {'g', 'y'}, {'8', 't'}, {'4', '6'}, {'6', 'p'}, {'g', 'z'}, {'i', 'u'}, {'o', 'q'}, {'l', 'w'}, {'w', '7'}, {'d', '3'}, {'3', 'r'}, {'3', 'p'}, {'p', 'k'}, {'8', 'q'}, {'m', 'd'}, {
                        'x', '0'}, {'a', 'f'}, {'j', 'n'}, {'b', 'm'}, {'b', 's'}, {'9', 'x'}, {'5', 'r'}, {'e', '3'}, {'7', 'z'}, {'7', 'i'}, {
                        '0', 'i'}, {'x', 'k'}, {'2', 'v'}, {'k', 'h'}, {'f', 'y'}, {'9', '0'}, {'h', '9'}, {'1', 'r'}, {'t', 'l'}, {'q', '3'}, {
                        '8', 'k'}, {'n', 'j'}, {'u', '8'}, {'f', 'h'}, {'w', '3'}, {'3', 'n'}, {'b', 'n'}, {'k', '3'}, {'f', 'x'}, {'h', '1'}, {
                        'n', 'i'}, {'q', '7'}, {'v', 'm'}, {'0', 'u'}, {'1', '9'}, {'d', 's'}, {'p', '7'}, {'5', 'y'}, {'j', 'v'}, {'5', 'g'}, {
                        '7', 'e'}, {'z', 'u'}, {'u', 'n'}, {'0', '8'}, {'l', 's'}, {'v', 'y'}, {'q', '2'}, {'d', 'x'}, {'e', 's'}, {'3', 'w'}, {
                        'r', 'e'}
                }));
    }
}

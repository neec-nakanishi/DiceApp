public class Chinchiro {
    Dice[] dices;
    Player oya;
    Player ko;

    String[] yaku = {"ピンゾロ", "あらし:6", "あらし:5", "あらし:4", "あらし:3", "あらし:2", "シゴロ","目:6", "目:5", "目:4", "目:3", "目:2", "目:1","役無し", "ヒフミ"};

    Chinchiro() {
        dices = new Dice[3];
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
        }
        oya = new Player("親");
        ko = new Player("子");
    }

    void start() {
        // 親がサイコロを振る
        int oyaResult = 13;
        System.err.print(oya.name+"の番");
        for (int i=0; i<3; i++) {
            oya.turn(dices);
            oyaResult = judge(dices);
            if (oyaResult!=13) {
                break;
            }
        }
        System.out.println();
        System.out.println(yaku[oyaResult]);
        System.out.println();    

        //　子がサイコロを振る
        System.err.print(ko.name+"の番");
        int koResult = judge(dices);
        for (int i=0; i<3; i++) {
            ko.turn(dices);
            koResult = judge(dices);
            if (koResult!=13) {
                break;
            }
        }
        System.out.println();
        System.out.println(yaku[koResult]);
        System.out.println();

        // 結果を表示
        if (oyaResult==koResult) {
            System.out.println("【引き分け】");
        }
        else if (oyaResult<koResult) {
            System.out.println("【親の勝ち】");
        }
        else {
            System.out.println("【子の勝ち】");
        }
        System.err.println();
    }

    int judge(Dice[] d) {
        // ピンゾロ
        if (d[0].me==1 && d[1].me==1 && d[2].me==1) {
            return 0;
        }
        // あらし
        else if (d[0].me==d[1].me && d[1].me==d[2].me) {
            return 7 - d[0].me;
        }
        // シゴロ
        else if (d[0].me*d[1].me*d[2].me==120) {
            return 6;
        }
        // 目
        else if (d[0].me==d[1].me) {
            return 7 + (6 - d[2].me);
        }
        else if (d[1].me==d[2].me) {
            return 7 + (6 - d[0].me);
        }
        else if (d[0].me==d[2].me) {
            return 7 + (6 - d[1].me);
        }
        // ヒフミ
        else if (d[0].me+d[1].me+d[2].me==6) {
            return 14;
        }
        // 役無し
        else {
            return 13;
        }
    }
}

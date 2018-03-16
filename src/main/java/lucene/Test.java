package lucene;

import java.io.StringReader;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

public class Test {


    private static String seg(String text, int mode) {
        PaodingAnalyzer ANALYZER = new PaodingAnalyzer();
        ANALYZER.setMode(mode);
        StringBuilder result = new StringBuilder();
        try {
            Token reusableToken = new Token();
            TokenStream stream = ANALYZER.tokenStream("", new StringReader(text));
            Token token = null;
            while ((token = stream.next(reusableToken)) != null) {
                result.append(token.term()).append("  ");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf
            .append(
                "我在地上捡到一分钱，地理图你们知道幸福是什么？关于这个问题，或许每个人心中的答案都不同。我们的生活经历不同，对于幸福的诠释，也就各有不同。但无论哪一种幸福的复述，都是源自一个人内心最温情的认知，和最丰裕的感受。 ")
            .append(
                " 　　幸福，是一种有趣的生活。一个人心灵与精神的富足，才最接近人生的完满。自己在有限的生存时间里，有一个好的状态，有一些情趣爱好，每天所做的事都顺应心意，感觉生动美好，就很幸福。比如读书、品茶、养花、画画，跑步、健身等，使人生达到一定境界，确是一种最靓丽而尚美的幸福生活。幸福，就是一个人每天明朗愉悦的好心情。 ")
            .append(
                " 　　幸福，是一份自觉的责任。周国平曾在与俞敏洪的访谈对话中说：“幸福，是家庭美满和事业成功的综合体。”一个有责任感的人，在履行中，就会自然而然地获得幸福。为事业、家庭，即使付出再多的汗水辛劳，内心也是很快乐的。展现自身的能力，体味亲情、爱情的美好；自身价值有所肯定，享受着成功的喜悦、品尝着自酿的甘美，必然是满满的幸福感。所以说：人类的一切努力的目的，在于获得幸福。 ")
            .append(
                " 　　幸福，是一切苦难的终结。张志新说：\"如果痛苦换来的是结识真理、坚持真理，就应自觉的欣然承受，那时，也只有那时，痛苦才将化为幸福。\"人总是在经历一些磨难悲痛之后，才会对以往以为的平常有所不同的感悟；总是在起伏跌宕之后，才会懂得一成不变的安稳与珍贵。我们最初的人生，曾向往生命的繁华景象，曾渴望山河岁月的浩荡模样，也曾为此拼的伤痕累累；等到了一定年纪，才会懂得，原来没有风浪、没有荆棘的人生，才是最安稳的幸福生活！ ")
            .append(
                " 　　幸福，是一颗懂得感恩的心。岁月流逝中，每一种缘分的姿态，都留下回望的感动；每一份真心的陪伴，都带着命运的恩慈。若能如此慈悲而深情地活着，所有过往人际的记取，都会化作心底的粒粒珍贵。懂得感恩的人，一定是富有的，一定是懂得珍惜的人。内心充满爱与感激，爱你的人也会更多，你就一定是个幸福的人。 ")
            .append(
                " 　　幸福，是一颗容易满足的心。幸福，不是你拥有多么优越的物质生活，而是你内心的愉悦晴朗，和一些小小的幸运与快乐、真切的宽容与满足。幸福的人，不与任何人攀比，也没有觊觎，只要自己觉得满意，就是最适合自己的生活。鲜衣怒马也好，素衣粗食也罢，倘若内心明媚温暖，寻常日子也会过得滋味丰足。时光里，心怀惊艳的绮盼，倒不如安于岁月的平宁静好。 ")
            .append(
                " 　　有一种幸福，其实并不遥远。你不断在追寻的幸福，也许就是平日被你忽视的生活；你值得珍惜的人，也许从来都妥贴地存在着。幸福，是你远行时父母亲的牵挂；是你下班时一盏等候的灯火、一桌热气腾腾的饭菜；是你心酸疲惫时可以温柔倾诉的人。人生四季，难免相遇风雨，幸福，是心底不缺失的一份温情与感动，撑起你生命的船帆！ ")
            .append(
                " 　　幸福，不是仰望的姿态，不是眺望的期盼，不是停不下来的努力，更不是多么华丽、浩荡的人生，而是一种细微、恬静的切切体味；而是你内心可以感受的一份踏实与温暖。日子周而复始，看似平淡无奇，然而，你能想到和想要的都拥有了，你以为最美最好的正在经历着，就是最难求的幸福了！ ");
        String seg = seg(sqlBuf.toString(), PaodingAnalyzer.MOST_WORDS_MODE);
        System.out.println(seg);
        String seg2 = seg(sqlBuf.toString(), PaodingAnalyzer.MAX_WORD_LENGTH_MODE);
        System.out.println(seg2);
    }

}

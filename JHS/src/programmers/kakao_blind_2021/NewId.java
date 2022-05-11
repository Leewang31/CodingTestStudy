package programmers.kakao_blind_2021;

public class NewId {
    public static void main(String[] args) {
        String newId = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(newId));
    }

    private static String solution(String new_id) {
        return new IdRecommendation(new_id)
                .replaceAllToLower()
                .removeETC()
                .replaceDoubleDot()
                .removeFirstAndLastDot()
                .blankId()
                .cutUnderFifteen()
                .fillThreeLength()
                .getNewId();
    }

    public static class IdRecommendation {
        private String id;

        public IdRecommendation(String id) {
            this.id = id;
        }

        public IdRecommendation replaceAllToLower() {
            id = id.toLowerCase();
            return this;
        }

        public IdRecommendation removeETC() {
            id = id.replaceAll("[^-_.0-9a-z]", "");
            return this;
        }

        public IdRecommendation replaceDoubleDot() {
            id = id.replaceAll("[..]+", ".");
            return this;
        }

        public IdRecommendation removeFirstAndLastDot() {
            id = id.replaceAll("^[.]", "").replaceAll("[.]$", "");
            return this;
        }

        public IdRecommendation blankId() {
            if (id.length() == 0) {
                id = "a";
            }
            return this;
        }

        public IdRecommendation cutUnderFifteen() {
            if (id.length() >= 16) {
                id = id.substring(0, 15).replaceAll("[.]$", "");
            }
            return this;
        }

        public IdRecommendation fillThreeLength() {
            if (id.length() <= 2) {
                String last = String.valueOf(id.charAt(id.length() - 1));
                while (id.length() < 3) {
                    id += last;
                }
            }
            return this;
        }

        public String getNewId() {
            return id;
        }
    }

}

package services;

// TODO: класс с месяцами года
public enum Month {
    JANUARY {
        @Override
        public String toString() {
            return "Январь";
        }
    },
    FEBRUARY {
        @Override
        public String toString() {
            return "Февраль";
        }
    },
    MARCH {
        @Override
        public String toString() {
            return "Март";
        }
    },
    APRIL {
        @Override
        public String toString() {
            return "Апрель";
        }
    },
    MAY {
        @Override
        public String toString() {
            return "Май";
        }
    },
    JUNE {
        @Override
        public String toString() {
            return "Июнь";
        }
    },
    JULY {
        @Override
        public String toString() {
            return "Июль";
        }
    },
    AUGUST {
        @Override
        public String toString() {
            return "Август";
        }
    },
    SEPTEMBER {
        @Override
        public String toString() {
            return "Сентябрь";
        }
    },
    OCTOBER {
        @Override
        public String toString() {
            return "Октябрь";
        }
    },
    NOVEMBER {
        @Override
        public String toString() {
            return "Ноябрь";
        }
    },
    DECEMBER {
        @Override
        public String toString() {
            return "Декабрь";
        }
    }


}

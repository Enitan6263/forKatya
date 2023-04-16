public class classFt_atoi {

    private static int compare(String str, int sign, int i) {
        long nbr = 0;
        while (i < str.length()) {
            nbr = nbr * 10 + (str.charAt(i) - '0');
            i++;
        }
        if (sign == -1) {
            if (nbr > 2147483648L)
                return (1);
        } else {
            if (nbr > 2147483647L)
                return (1);
        }
        return (0);
    }

    private static int ft_overflow(String str, int i, int sign) {
        int k = 0;
        int j = i;
        while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
            j++;
            k++;
        }
        if (compare(str, sign, i) == 1) {
            if (sign > 0)
                return (-1);
            else
                return (0);
        }
        if (k > 10 && sign > 0)
            return (-1);
        else if (k > 10 && sign < 0)
            return (0);
        return (1);
    }

    public static int ft_atoi(String str) {
        int nbr = 0;
        int i = 0;
        int sign = 1;
        while (i < str.length() && (str.charAt(i) >= '\t' && str.charAt(i) <= '\r') || str.charAt(i) == ' ')
            i++;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-')
                sign = -1;
            i++;
        }
        while (i < str.length() && str.charAt(i) == '0')
            i++;
        if (ft_overflow(str, i, sign) == 0 || ft_overflow(str, i, sign) == -1)
            return ft_overflow(str, i, sign);
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            nbr = nbr * 10 + (str.charAt(i) - '0');
            i++;
        }
        return nbr * sign;
    }
}

public class Searching19 {
    int binarySearch(ClassPeminjaman19[] data, String nim) {
    int left = 0, right = data.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (data[mid].mhs.nim.equals(nim)) {
            return mid;
        } else if (data[mid].mhs.nim.compareTo(nim) < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
    }
}

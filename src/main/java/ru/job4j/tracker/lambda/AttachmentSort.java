package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachmentList = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachmentList.sort(comparator);
        System.out.println(attachmentList);
        Comparator<Attachment> attachmentComparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachmentList.sort(attachmentComparator);
        System.out.println(attachmentList);
    }
}

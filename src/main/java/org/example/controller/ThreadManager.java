package org.example.controller;

import org.example.model.Consumer;
import org.example.model.Producer;
import org.example.model.ResourceType;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {

        public static final List<ResourceType> typeAThreads = new ArrayList<>();
        public static final List<Producer> typeBThreads = new ArrayList<>();
        public static final List<Consumer> typeCThreads = new ArrayList<>();

        //TODO arreglar esta mierda
        public static Object[][] getThreadData(List<? extends Runnable> threads) {
            Object[][] data = new Object[threads.size()][3];
            for (int i = 0; i < threads.size(); i++) {
                if (threads.get(i) instanceof ResourceType a) {
                    data[i][0] = a.getName();
                    data[i][1] = a.getId();
                    data[i][2] = a.getChangingValue(); // Only the changing value updates
                } else if (threads.get(i) instanceof Producer b) {
                    data[i][0] = b.getName();
                    data[i][1] = b.getId();
                    data[i][2] = b.getChangingValue();
                } else if (threads.get(i) instanceof Consumer c) {
                    data[i][0] = c.getName();
                    data[i][1] = c.getId();
                    data[i][2] = c.getChangingValue();
                }
            }
            return data;
        }

}

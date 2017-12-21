package com.alex.morgan.bearlist.list;

import com.alex.morgan.bearlist.Bear;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.inject.Inject;

class StaticBearSource implements BearSource {

    private final BearNameGenerator nameGenerator;

    @Inject
    StaticBearSource(BearNameGenerator nameGenerator) {
        this.nameGenerator = nameGenerator;
    }

    @Override
    public Collection<Bear> getAllBears() {
        try {
            //Long operation here
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Bear> bears = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            bears.add(this.randomBear());
        }
        return bears;
    }

    private static final Random random = new Random();

    private Bear randomBear() {
        return new Bear(nameGenerator.getRandomBearName(),
                "https://placebear.com/"
                        + (random.nextInt(100) + 50) + "/"
                        + (random.nextInt(100) + 50) + ".jpg");
    }
}

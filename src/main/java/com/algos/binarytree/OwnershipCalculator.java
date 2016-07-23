package com.algos.binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * (Note: This question was asked in Bloomberg interview)
 *
 *              A
 *         B          C
 *     D      E   F      G
 *
 * Given a tree like above where
 *      A owns 50% of B
 *      A owns 33% of C
 *      B owns 20% of D, ...
 *
 * Given two entities as input, calculate how much the parent owns the child. For e.g., in the given example,
 * A owns 3.3% of F
 *
 * User: Fizal
 * Date: 7/19/2016
 * Time: 12:57 PM
 */
public class OwnershipCalculator {

    public static void main(String[] args) {
        Entity a = new Entity("A");
        Entity b = new Entity("B");
        Entity c = new Entity("C");
        Entity d = new Entity("D");
        Entity e = new Entity("E");
        Entity f = new Entity("F");
        Entity g = new Entity("G");

        Relation o1 = new Relation(a, b, 50);
        Relation o2 = new Relation(a, c, 33);
        Relation o3 = new Relation(b, d, 20);
        Relation o4 = new Relation(b, e, 30);
        Relation o5 = new Relation(c, f, 10);
        Relation o6 = new Relation(c, g, 15);

        Map<Entity, Relation> map = new HashMap<>();
        for (Relation relation : Arrays.asList(o1, o2, o3, o4, o5, o6)) {
            map.put(relation.child, relation);
        }

        System.out.println(calculateOwnership(map, a, b)); // 50.0
        System.out.println(calculateOwnership(map, a, d)); // 10.0
        System.out.println(calculateOwnership(map, a, e)); // 15.0
    }


    private static double calculateOwnership(Map<Entity, Relation> map, Entity parent, Entity child){

        if(!map.containsKey(child)){
            return 0.0;
        }

        double ownershipPercent = 0.0;
        while(true){
            final Relation relation = map.get(child);

            ownershipPercent = ownershipPercent==0.0? relation.getOwnership():ownershipPercent * (relation.getOwnership()/100);
            if(relation.getParent().equals(parent)){
                break;
            } else {
                child = relation.getParent();
            }
        }

        return ownershipPercent;
    }

    /**
     *
     */
    private static class Entity{
        private String name;

        public Entity(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entity entity = (Entity) o;

            return name != null ? name.equals(entity.name) : entity.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     *
     */
    private static class Relation {
        private Entity parent;
        private Entity child;
        private double ownership;

        public Relation(Entity parent, Entity child, double ownership) {
            this.parent = parent;
            this.child = child;
            this.ownership = ownership;
        }

        public Entity getParent() {
            return parent;
        }

        public Entity getChild() {
            return child;
        }

        public double getOwnership() {
            return ownership;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Ownership{");
            sb.append("parent=").append(parent);
            sb.append(", child=").append(child);
            sb.append(", ownership=").append(ownership);
            sb.append('}');
            return sb.toString();
        }
    }
}

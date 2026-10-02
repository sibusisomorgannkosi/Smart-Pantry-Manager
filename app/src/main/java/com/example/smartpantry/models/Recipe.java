package com.example.smartpantry.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable {
    private int id; private String name; private String description; private String instructions;
    private List<RecipeIngredient> ingredients;

    public Recipe(){ingredients=new ArrayList<>();}
    public Recipe(int id,String name,String description,String instructions){this.id=id;this.name=name;this.description=description;this.instructions=instructions;ingredients=new ArrayList<>();}
    public Recipe(String name,String description,String instructions){this.name=name;this.description=description;this.instructions=instructions;ingredients=new ArrayList<>();}
    public int getId(){return id;} public String getName(){return name;} public String getDescription(){return description;}
    public String getInstructions(){return instructions;} public List<RecipeIngredient> getIngredients(){return ingredients;}
    public void setId(int id){this.id=id;} public void setName(String name){this.name=name;} public void setDescription(String description){this.description=description;}
    public void setInstructions(String instructions){this.instructions=instructions;} public void setIngredients(List<RecipeIngredient> ingredients){this.ingredients=ingredients;}
    public void addIngredient(RecipeIngredient ingredient){if(ingredients==null)ingredients=new ArrayList<>();ingredients.add(ingredient);}
    @Override public String toString(){return "Recipe{"+"id="+id+", name='"+name+'\''+", description='"+description+'\''+", ingredients="+ingredients.size()+'}';}
}

<?php

namespace App\Http\Controllers;

use App\Serie;

class SerieController extends Controller
{
    public function index()
    {
    return Serie::all();
    }


    public function create(Request $request)
    {

        $serie = new Serie();

        $serie->nome = $request->nome;
        $serie->descricao= $request->descricao;
        $serie->imdb= $request->idmb;
        $serie->image=$request->image;
        $serie->idcategoria= $request-> idcategoria;

        $serie->save();
    }

    public function show($id)
    {
        return Serie::find($id);
    }


    public function update(Request $request, $id)
    {
        $serie = Article::findOrFail($id);
        $serie->update($request->all());

        return $serie;
    }

    public function delete(Request $request, $id)
    {
        $serie = Serie::findOrFail($id);
        $serie->delete();

        return $request;
    }

}

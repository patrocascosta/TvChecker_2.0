<?php

namespace App\Http\Controllers;

use App\Episodio;
use Illuminate\Http\Request;

class EpisodiosController extends Controller
{
    public function index()
    {
        return Episodio::all();
    }


    public function create(Request $request)
    {

        $episodio = new Episodio();

        $episodio->nome = $request->nome;
        $episodio-> idcategoria= $request-> idcategoria;

        $episodio->save();
    }

    public function show($id)
    {
        return Episodio::find($id);
    }


    public function update(Request $request, $id)
    {
        $episodio = Episodio::findOrFail($id);
        $episodio->update($request->all());

        return $episodio;
    }

    public function delete(Request $request, $id)
    {
        $episodio = Episodio::findOrFail($id);
        $episodio->delete();

        return $request;
    }

}

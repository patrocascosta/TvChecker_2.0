<?php

namespace App\Http\Controllers;

use App\Categoria;
use Illuminate\Http\Request;

class CategoriasController extends Controller
{
    public function index()
    {
        return Categoria::all();
    }


    public function create(Request $request)
    {

        $categoria = new Categoria();

        $categoria->nome = $request->nome;
        $categoria-> idcategoria= $request-> idcategoria;


        $$categoria->save();
    }

    public function show($id)
    {
        return Categoria::find($id);
    }


    public function update(Request $request, $id)
    {
        $categoria = Episodio::findOrFail($id);
        $categoria->update($request->all());

        return $categoria;
    }

    public function delete(Request $request, $id)
    {
        $categoria = Episodio::findOrFail($id);
        $categoria->delete();

        return $request;
    }
}

<?php

namespace App\Http\Controllers;

use App\Favoritos;
use Illuminate\Http\Request;

class FavoritosController extends Controller
{
    public function index()
    {
        return Favoritos::all();
    }


    public function create(Request $request)
    {

        $favoritos = new Favoritos();

        $favoritos->idUser = $request->idUser;
        $favoritos-> idSerie= $request-> idSerie;
        $favoritos-> favorito= $request-> favorito;

        $favoritos->save();
    }

    public function show($id)
    {
        return Favoritos::find($id);
    }


    public function update(Request $request, $id)
    {
        $favorito = Favoritos::findOrFail($id);
        $favorito->update($request->all());

        return $favorito;
    }

    public function delete(Request $request, $id)
    {
        $favorito = Favoritos::findOrFail($id);
        $favorito->delete();

        return $request;
    }

}

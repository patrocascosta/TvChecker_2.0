<?php

namespace App\Http\Controllers;

use App\Episodio;
use App\Temporada;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Schema;

class TemporadasController extends Controller
{
 public function index()
{
    return Temporada::all();
}


    public function create(Request $request)
{

    $temporada = new Episodio();

    $temporada->nome = $request->nome;

    $temporada->save();
}

    public function show($id)
{
    return Temporada::find($id);
}


    public function update(Request $request, $id)
{
    $temporada = Temporada::findOrFail($id);
    $temporada->update($request->all());

    return $temporada;
}

    public function delete(Request $request, $id)
{
    $temporada = Episodio::findOrFail($id);
    $temporada->delete();

    return $request;
}
}

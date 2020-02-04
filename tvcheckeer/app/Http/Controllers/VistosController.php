<?php

namespace App\Http\Controllers;

use App\Vistos;
use Illuminate\Http\Request;

class VistosController extends Controller
{
    public function index()
    {
        return Vistos::all();
    }


    public function create(Request $request)
    {

        $vistos = new Vistos();

        $vistos->idUser = $request->idUser;
        $vistos-> idSerie= $request-> idSerie;
        $vistos-> idUser= $request-> idSerie;
        $vistos-> visto= $request-> visto;
        $vistos-> image= $request-> image;

        $vistos->save();
    }

    public function show($id)
    {
        return Vistos::find($id);
    }


    public function update(Request $request, $id)
    {
        $vistos = Vistos::findOrFail($id);
        $vistos->update($request->all());

        return $vistos;
    }

    public function delete(Request $request, $id)
    {
        $vistos = Vistos::findOrFail($id);
        $vistos->delete();

        return $request;
    }
}

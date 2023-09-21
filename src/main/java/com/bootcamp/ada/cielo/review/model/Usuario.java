package com.bootcamp.ada.cielo.review.model;

import com.bootcamp.ada.cielo.review.model.Cliente;
import com.bootcamp.ada.cielo.review.model.Empresa;

public sealed abstract class Usuario permits Empresa, Cliente {

}

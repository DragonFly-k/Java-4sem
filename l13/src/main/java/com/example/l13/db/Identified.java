package com.example.l13.db;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {
    PK getId();
}
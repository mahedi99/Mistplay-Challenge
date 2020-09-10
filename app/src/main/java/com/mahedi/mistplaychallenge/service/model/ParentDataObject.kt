package com.mahedi.mistplaychallenge.service.model

/**
 * @author Mahedi Hassan
 * 2020-09-09
 */

class ParentDataObject(val title: String) : HasType {
    override fun getType(): Int {
        return Holder.PARENT.type
    }
}
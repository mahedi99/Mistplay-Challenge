package com.mahedi.mistplaychallenge.service.model

/**
 * @author Mahedi Hassan
 * 2020-09-09
 */

class ChildrenDataObject (val nestedDataObjectList: List<Games>) : HasType {
    override fun getType(): Int {
        return Holder.NESTED.type
    }
}
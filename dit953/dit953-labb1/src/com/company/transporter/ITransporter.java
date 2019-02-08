package com.company.transporter;

import com.company.core.IStorable;
import com.company.movable.IMovable;
import com.company.transportable.ITransportable;

public interface ITransporter<T extends ITransportable> extends IStorable<T>, IMovable {

}

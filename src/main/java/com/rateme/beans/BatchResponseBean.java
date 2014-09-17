package com.rateme.beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "batchResponse")
public class BatchResponseBean extends ArrayList<NextResponseBean> {
}

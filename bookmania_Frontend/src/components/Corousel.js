import React from 'react';

import Image1 from './images/Corousel-Img1.jpg';
import Image2 from './images/Corousel-Img2.jpg';
import Image3 from './images/Corousel-Img3.jpg';
import './Corousel.css';

import {
  MDBCarousel,
  MDBCarouselItem,
} from 'mdb-react-ui-kit';

function Corousel(){
return(<section>

<MDBCarousel showControls showIndicators className = "CarouselClass">
      <MDBCarouselItem
        className='w-100 d-block'
        itemId={1}
        src={Image1}
        alt='...'
      />
      <MDBCarouselItem
        className='w-100 d-block'
        itemId={2}
        src={Image2}
        alt='...'
      />
      <MDBCarouselItem
        className='w-100 d-block'
        itemId={3}
        src={Image3}
        alt='...'
      />
    </MDBCarousel>
    
    </section>
);   
}

export default Corousel;